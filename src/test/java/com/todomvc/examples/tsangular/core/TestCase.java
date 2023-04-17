package com.todomvc.examples.tsangular.core;

import com.todomvc.examples.tsangular.pages.TodoExamplePage;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase extends ChromeRunner {

    private static final String BASE_URL = "https://todomvc.com/examples";

    protected TodoExamplePage openTodoExamplePage() {
        driver.get(BASE_URL + "/typescript-angular");
        return new TodoExamplePage(driver);
    }

    protected void clearLocalStorage() {
        ((JavascriptExecutor)(driver)).executeScript("window.localStorage.clear();");
    }
}
