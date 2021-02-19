package org.example.data;

import org.example.jdbc.MySqlConnection;
import org.example.model.Person;
import org.example.model.Todo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsImpl implements  TodoItems{
    @Override
    public Todo create(Todo todo) {
        Todo todo2 = new Todo();
        String query ="Insert into todo_item values (?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setInt(1,todo.getId());
            preparedStatement.setString(2,todo.getTitle());
            preparedStatement.setString(3,todo.getDescription());
            preparedStatement.setDate(4, (Date) todo.getDeadLine());
            preparedStatement.setBoolean(5,todo.isDone());
            preparedStatement.setInt(6,todo.getAssignee_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public Collection<Todo> findAll() {
        String query = "Select * from todo_item";
        Collection<Todo> list = new ArrayList<>();
        Todo todo = new Todo();

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ) {

              ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()){
                  list.add(new Todo(resultSet.getInt(1),
                          resultSet.getString(2),
                          resultSet.getString(3),
                          resultSet.getDate(4),
                          resultSet.getBoolean(5),
                          resultSet.getInt(6)));
              }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
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
