package com.todomvc.examples.tsangular.core;

import com.todomvc.examples.tsangular.pages.TodoExamplePage;

public class TestCase extends ChromeRunner {

    private static final String baseUrl = "https://todomvc.com/examples";

    protected TodoExamplePage openTodoExamplePage() {
        driver.get(baseUrl + "/typescript-angular");
        return new TodoExamplePage(driver);
    }
}
