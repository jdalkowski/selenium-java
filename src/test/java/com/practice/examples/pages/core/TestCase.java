package com.practice.examples.pages.core;

import com.practice.examples.pages.ReactShopPage;
import com.practice.examples.pages.TodoExamplePage;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase extends ChromeRunner {

    private static final String TODO_SITE = "https://todomvc.com/examples/typescript-angular";
    private static final String REACT_SHOP_SITE = "https://react-shopping-cart-67954.firebaseapp.com/";

    protected TodoExamplePage openTodoExamplePage() {
        driver.get(TODO_SITE);
        return new TodoExamplePage(driver);
    }

    protected ReactShopPage openReactShopPage() {
        driver.get(REACT_SHOP_SITE);
        return new ReactShopPage(driver);
    }

    protected void clearLocalStorage() {
        ((JavascriptExecutor)(driver)).executeScript("window.localStorage.clear();");
    }
}
