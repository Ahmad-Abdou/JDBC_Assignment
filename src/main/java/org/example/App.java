package org.example;


import org.example.data.PeopleImp;
import org.example.data.TodoItemsImpl;
import org.example.model.Todo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PeopleImp pi = new PeopleImp();
//        System.out.println("Creating Person");
//        Person person1 = pi.create(new Person(10, "Alex", "Thompson"));
//        System.out.println(person1.toString());
//        System.out.println("################################");
//        System.out.println("Finding All");
//        Collection<Person> personList = pi.findAll();
//        personList.forEach(System.out::println);
//        System.out.println("################################");
//        System.out.println("Finding by id");
//        Person person = pi.findById(6);
//        System.out.println(person);
//        System.out.println("################################");
//        System.out.println("Finding by Name");
//        Collection<Person>list = pi.findByName("Simon");
//        list.forEach(System.out::println);
//        System.out.println("################################");
//       Person person2 = pi.update(new Person(2,"Sam","Sage"));
//        System.out.println(person2.toString());
//        System.out.println("################################");
//        System.out.println("Deleting");
//        System.out.println(pi.deleteById(2));

        //                    TODO
        System.out.println("Todo");
        TodoItemsImpl td = new TodoItemsImpl();
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        System.out.println(td.create(new Todo(3,"Assignment","Programming", sqlDate,true,10)));
          System.out.println("################################");
          Collection<Todo> todo2 = td.findAll();
          todo2.forEach(System.out::println);
          System.out.println("################################");




    }
}