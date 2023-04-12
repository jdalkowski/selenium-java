package com.todomvc.examples.tsangular.tests;

import com.todomvc.examples.tsangular.core.TestCase;
import com.todomvc.examples.tsangular.pages.TodoExamplePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TodoMvcTest extends TestCase {

    private TodoExamplePage todoExamplePage;

    @BeforeClass
    public void prepareTest() {
        todoExamplePage = openTodoExamplePage();
    }

    @Test
    public void shouldAddTodoNotes() {
        todoExamplePage.addTodoNote("first note");
        todoExamplePage.addTodoNote("second note");
        todoExamplePage.addTodoNote("third note");
        assertThat(todoExamplePage.getTodoElementList().size()).isEqualTo(3);
    }
}
