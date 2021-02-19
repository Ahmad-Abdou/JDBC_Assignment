package org.example;


import org.example.data.PeopleImp;
import org.example.data.TodoItemsImpl;
import org.example.model.Person;
import org.example.model.Todo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PeopleImp pi = new PeopleImp();
        System.out.println("##################################  Person  ################################################");
        System.out.println("Creating Person");
//        Person person1 = pi.create(new Person(0, "Sari", "Moon"));
//        System.out.println(person1.toString());
        System.out.println("################################");
        System.out.println("Finding All");
//        Collection<Person> personList = pi.findAll();
//        personList.forEach(System.out::println);
        System.out.println("################################");
        System.out.println("Finding by id");
//        Person person = pi.findById(6);
//        System.out.println(person);
        System.out.println("################################");
        System.out.println("Finding by Name");
//        Collection<Person>list = pi.findByName("Simon");
//        list.forEach(System.out::println);
        System.out.println("################################");
        System.out.println("Updating");
//       Person person2 = pi.update(new Person(2,"Sam","Sage"));
//        System.out.println(person2.toString());
        System.out.println("################################");
        System.out.println("Deleting");
//        System.out.println(pi.deleteById(2));

        //                    TODO
        System.out.println("##################################  Todo  ##################################################");
        TodoItemsImpl td = new TodoItemsImpl();
        System.out.println("Creating");
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        System.out.println(td.create(new Todo(1,"Exam","Passed", sqlDate,true,1)));
          System.out.println("################################");
//          Collection<Todo> todo2 = td.findAll();
        System.out.println("Finding All");
//          todo2.forEach(System.out::println);
          System.out.println("################################");
        System.out.println("Finding by ID");
//          System.out.println(td.findByID(1));
           System.out.println("################################");
        System.out.println("Finding by status");
//        System.out.println(td.findByDoneStatus(true));
        System.out.println("################################");
        System.out.println("Finding by Assignee");
//        System.out.println(td.findByAssignee(9));
        System.out.println("################################");
        System.out.println("Finding by Assignee using person ID");
//        System.out.println(td.findByAssignee(new Person(9,"Mehrdad","Javan")));
        System.out.println("################################");
        System.out.println("Updating");
//        java.util.Date utilDate2 = new java.util.Date();
//        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
//        System.out.println(td.update(new Todo(8,"Exam","Passed",sqlDate2,true,8)));
        System.out.println("################################");
        System.out.println("Deleting");
//        System.out.println(td.deleteById(2));
        System.out.println("############################################################################################");


    }
}