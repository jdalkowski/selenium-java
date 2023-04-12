package com.todomvc.examples.tsangular.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public TodoExamplePage(final WebDriver driver) {
        super(driver);
    }

    @Step
    public void addTodoNote (String noteText) {
        todoInput.sendKeys(noteText);
        todoInput.sendKeys(Keys.ENTER);
    }
}
