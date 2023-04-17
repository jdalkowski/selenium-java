package com.todomvc.examples.tsangular.tests;

import com.todomvc.examples.tsangular.core.TestCase;
import com.todomvc.examples.tsangular.pages.TodoExamplePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoMvcTest extends TestCase {

    private static final String firstNote = "Test note number one";
    private static final String secondNote = "Test note number two";
    private static final String thirdNote = "Test note number three";

    private TodoExamplePage todoExamplePage;

    @BeforeMethod
    public void prepareTest() {
        todoExamplePage = openTodoExamplePage();
    }

    @Test
    public void shouldAddTodoNotes() {
        addThreeTodoItems();
        assertThat(todoExamplePage.getTodoElementList().size()).isEqualTo(3);
        assertThat(todoExamplePage.getTodoElementList().get(0).getText()).isEqualTo(firstNote);
        assertThat(todoExamplePage.getTodoElementList().get(1).getText()).isEqualTo(secondNote);
        assertThat(todoExamplePage.getTodoElementList().get(2).getText()).isEqualTo(thirdNote);
    }

    @Test
    public void shouldMarkNoteAsCompleted() {
        addThreeTodoItems();
        todoExamplePage.markNoteAsCompleted(0);
        assertThat(todoExamplePage.countNumberOfCompletedItems()).isEqualTo(1);
        assertThat(todoExamplePage.getItemsLeft()).isEqualTo(todoExamplePage.getTodoElementList()
                .size()-todoExamplePage.countNumberOfCompletedItems());
    }

    @Test
    public void shouldRemoveTodoNoteFromList() {
        addThreeTodoItems();
        assertThat(todoExamplePage.getTodoElementList().size()).isEqualTo(3);
        todoExamplePage.removeTodoNote(1);
        assertThat(todoExamplePage.getTodoElementList().size()).isEqualTo(2);
    }

    private void addThreeTodoItems() {
        todoExamplePage.addTodoNote(firstNote);
        todoExamplePage.addTodoNote(secondNote);
        todoExamplePage.addTodoNote(thirdNote);
    }
}