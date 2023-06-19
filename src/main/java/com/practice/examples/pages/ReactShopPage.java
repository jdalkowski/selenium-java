package com.practice.examples.pages;

import com.practice.examples.components.react_shop_site.ShoppingCart;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ReactShopPage extends WebPage {

    @FindBy(css = "div.sc-124al1g-2")
    private List<WebElement> productList;

    @FindBy(css = "div.sc-1h98xa9-3")
    private WebElement productsInCartCounter;

    @FindBy(css = "button.sc-1h98xa9-0")
    private WebElement shopCartButton;

    @FindBy(css = "div.sc-1h98xa9-1")
    private WebElement shoppingCart;

    public ReactShopPage(final WebDriver driver) {
        super(driver);
    }

    @Step
    public void addProductToCart(int itemIndex) {
        productList.get(itemIndex).findElement(By.tagName("button")).click();
    }

    @Step
    public ShoppingCart expandShoppingCart() {
        if (!shoppingCart.isDisplayed()) {
            shopCartButton.click();
        }
        return new ShoppingCart(driver, shoppingCart);
    }

    @Step
    public int getNumberOfProductsInCart() {
        wait.until(ExpectedConditions.visibilityOf(productsInCartCounter));
        return Integer.parseInt(productsInCartCounter.getText());
    }

    @Step
    public String getProductName(int productIndex) {
        return productList.get(productIndex).findElement(By.cssSelector("p.sc-124al1g-4")).getText();
    }
}
