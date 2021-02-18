package org.example.model;

import java.util.Date;
import java.util.Objects;

public class Todo {

    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private boolean done;
    private int assignee_id;

    public Todo() {
    }

    public Todo(int id, String title, String description, Date deadLine, boolean done, int assignee_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && done == todo.done && assignee_id == todo.assignee_id && Objects.equals(title, todo.title) && Objects.equals(description, todo.description) && Objects.equals(deadLine, todo.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadLine, done, assignee_id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", assignee_id=" + assignee_id +
                '}';
    }
}


