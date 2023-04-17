package com.todomvc.examples.tsangular.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoExamplePage extends WebPage {

    @FindBy(css = "header.header>h1")
    private WebElement pageHeader;

    @FindBy(css = "input.new-todo")
    private WebElement todoInput;

    @Getter
    @FindBy(css = "ul.todo-list>li")
    private List<WebElement> todoElementList;

    @FindBy(css = "span.todo-count>strong")
    private WebElement itemsLeftCounter;

    public TodoExamplePage(final WebDriver driver) {
        super(driver);
    }

    @Step
    public void addTodoNote (String noteText) {
        todoInput.sendKeys(noteText);
        todoInput.sendKeys(Keys.ENTER);
    }

    @Step
    public void markNoteAsCompleted(int index) {
        todoElementList.get(index).findElement(By.tagName("input")).click();
    }

    @Step
    public int getItemsLeft() {
        return Integer.parseInt(itemsLeftCounter.getText());
    }

    @Step
    public int countNumberOfCompletedItems() {
        return (int) todoElementList
                .stream()
                .filter(e -> e.getAttribute("class").contains("completed"))
                .count();
    }

    public void removeTodoNote(int elementIndex) {
        Actions actions = new Actions(driver);
        actions.moveToElement(todoElementList.get(elementIndex)).build().perform();
        driver.findElements(By.cssSelector("button.destroy")).get(elementIndex).click();
    }
}
