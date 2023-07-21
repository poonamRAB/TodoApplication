package com.geekster.TODOAPP.Entity;

public class Todo {
    private Integer todoId;

    private String todoName;
    private boolean isTodoDoneStatus;

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean isTodoStatus() {
        return isTodoDoneStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.isTodoDoneStatus = todoStatus;
    }
}
