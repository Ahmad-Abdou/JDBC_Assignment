package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.Collection;

public class TodoItemsImpl implements  TodoItems{
    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findByID(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
