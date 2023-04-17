package com.todomvc.examples.tsangular.tests;

import com.todomvc.examples.tsangular.core.TestCase;
import com.todomvc.examples.tsangular.pages.TodoExamplePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoMvcTest extends TestCase {

    private static final String FIRST_NOTE = "Test note number one";
    private static final String SECOND_NOTE = "Test note number two";
    private static final String THIRD_NOTE = "Test note number three";

    private TodoExamplePage todoExamplePage;

    @BeforeMethod
    public void prepareTest() {
        todoExamplePage = openTodoExamplePage();
    }

    @Test
    public void shouldAddTodoNotes() {
        addThreeTodoItems();
        final List<WebElement> todoNoteList = todoExamplePage.getTodoElementList();
        assertThat(todoNoteList).hasSize(3);
        assertThat(todoNoteList.get(0).getText()).isEqualTo(FIRST_NOTE);
        assertThat(todoNoteList.get(1).getText()).isEqualTo(SECOND_NOTE);
        assertThat(todoNoteList.get(2).getText()).isEqualTo(THIRD_NOTE);
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
        final List<WebElement> todoNoteList = todoExamplePage.getTodoElementList();
        assertThat(todoNoteList).hasSize(3);
        todoExamplePage.removeTodoNote(1);
        assertThat(todoNoteList).hasSize(2);
    }

    @AfterMethod
    public void clearStorage() {
        clearLocalStorage();
    }

    private void addThreeTodoItems() {
        todoExamplePage.addTodoNote(FIRST_NOTE);
        todoExamplePage.addTodoNote(SECOND_NOTE);
        todoExamplePage.addTodoNote(THIRD_NOTE);
    }
}