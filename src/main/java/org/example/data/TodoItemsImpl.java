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
        String query = "Select * from todo_item where todo_id = ?";
        Todo todo = new Todo();

        try(PreparedStatement  preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                todo.setId(resultSet.getInt(1));
                todo.setTitle(resultSet.getString(2));
                todo.setDescription(resultSet.getString(3));
                todo.setDeadLine(resultSet.getDate(4));
                todo.setDone(resultSet.getBoolean(5));
                todo.setAssignee_id(resultSet.getInt(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todo;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {
        Collection<Todo> list = new ArrayList<>();
        String query ="Select * from todo_item where done = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setBoolean(1,status);
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
    public Collection<Todo> findByAssignee(int assignee) {
        Collection<Todo> list = new ArrayList<>();
        String query = "select * from todo_item where assignee_id = ?";

        try( PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setInt(1,assignee);
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
    public Collection<Todo> findByAssignee(Person person) {
        Collection<Todo> list = new ArrayList<>();
        String query = "select * from todo_item where assignee_id = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setInt(1,person.getId());
            ResultSet resultSet =preparedStatement.executeQuery();
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
    public Collection<Todo> findByUnassignedTodoItems() {
        Collection<Todo> list = new ArrayList<>();
        String query = "Select * from todo_item where Assignee_id = null";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Todo(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getBoolean(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Todo update(Todo todo) {
        String query = "Update todo_item set title = ? , description = ? , deadline = ? , done = ? , Assignee_id = ? where todo_id = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){

            preparedStatement.setString(1,todo.getTitle());
            preparedStatement.setString(2,todo.getDescription());
            preparedStatement.setDate(3, (Date) todo.getDeadLine());
            preparedStatement.setBoolean(4,todo.isDone());
            preparedStatement.setInt(5,todo.getAssignee_id());
            preparedStatement.setInt(6,todo.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return todo;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "Delete from todo_item where todo_id = ?";

        boolean result = false;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ) {

             preparedStatement.setInt(1,id);
             if( preparedStatement.executeUpdate() == 1){
                 result = true;
             }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
}
