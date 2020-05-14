package com.saif.todolist;

import datamodel.TodoData;
import datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker datePicker;

    public void setTodoDetails(TodoItem item) {
        titleField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        datePicker.setValue(item.getDeadline());
    }

    public TodoItem processResults() {
        String title = titleField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate date = datePicker.getValue();
        TodoItem newItem = new TodoItem(title, details, date);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
