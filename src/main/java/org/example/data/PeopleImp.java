package org.example.data;

import org.example.jdbc.MySqlConnection;
import org.example.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleImp implements People{
    @Override
    public Person create(Person person) {
        String query = "insert into person values(?,?,?)";
        Person person1 = new Person();

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){

          preparedStatement.setInt(1,person.getId());
          preparedStatement.setString(2,person.getName());
          preparedStatement.setString(3,person.getLastName());
          preparedStatement.executeUpdate();

          person1 = person;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person1;
    }

    @Override
    public Collection<Person> findAll() {
        Collection<Person> list = new ArrayList<>();
        try ( PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement("select * from person");
        ){
           ResultSet resultSet= preparedStatement.executeQuery("select * from person");
            while (resultSet.next()){
                list.add(new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person findById(int id) {
        Person person = new Person();
        String query = "select * from person where person_id = ?";
        try ( PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {

        String query = "select * from person where first_name = ?";
        Collection<Person> list = new ArrayList<>();

        try ( PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setString(1,name);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Person update(Person person) {


        String query = "update person set first_name = ? , last_name = ? where person_id = ?";
        try(PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ) {

            preparedStatement.setString(1,person.getName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setInt(3,person.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from person where person_id = ?";
        boolean result = false;
        try ( PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query);
        ){
            preparedStatement.setInt(1,id);

           if(preparedStatement.executeUpdate() == 1 ){
               result = true;
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
