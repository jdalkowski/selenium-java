package com.practice.examples.components.react_shop_site;

import com.practice.examples.pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCart extends WebPage {

    @FindBy(css = "div.sc-1h98xa9-3")
    private WebElement itemsCounter;

    @FindBy(css = "div.sc-11uohgb-0")
    private List<WebElement> productList;

    @FindBy(css = "div.sc-11uohgb-4>p")
    private List<WebElement> priceList;

    @FindBy(css = "p.jzywDV")
    private WebElement subtotal;

    @FindBy(css = "button.sc-1h98xa9-11")
    private WebElement checkoutBtn;

    protected final WebDriverWait wait;

    public ShoppingCart(WebDriver driver, WebElement shoppingCart) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Step
    public int getNumberOfProductInCart() {
        return Integer.parseInt(itemsCounter.getText());
    }

    @Step
    public String getProductName(int productIndex) {
        return productList.get(productIndex).findElement(By.cssSelector("p.sc-11uohgb-2")).getText();
    }

    @Step
    public double countProductsSubtotal() {
        return priceList.stream()
                .map(item->item.getText().replace("$ ", ""))
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    @Step
    public double getSubtotalFromBasket() {
        return Double.parseDouble(subtotal.getText().replace("$ ", ""));
    }

    @Step
    public String getCheckoutSubtotal() {
        checkoutBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    private WebElement shoppingCart() {
        return driver.findElement(By.cssSelector("div.sc-1h98xa9-1"));
    }
}