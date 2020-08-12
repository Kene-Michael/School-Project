package models;

import utils.Role;
import utils.LibraryUtils;
import utils.UserUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library decaLibrary = new Library("DecaLibrary");
        LibraryUtils libraryUtils = new LibraryUtils(decaLibrary);
        libraryUtils.createBook("Intro to Java","Odira","Java",465,"Java1");
        libraryUtils.createBook("Intro to Java","Odira","Java",465,"Java1");
        libraryUtils.createBook("Intro to OOP","Daro","Java",47,"Java2");
        libraryUtils.createBook("Intro to MAP","LONGE","Java",494,"Java6");
        libraryUtils.createBook("Intro to SET","OSE","Java",678,"Java5");
        libraryUtils.getBook("Java2");
        System.out.println(decaLibrary.getBooks().get("Java1").getTotalNoOfBooks());
        System.out.println(decaLibrary.getBooks().get("Java2").getTotalNoOfBooks());
        System.out.println(decaLibrary.getBooks().get("Java2").getAvailableBooks());
        User user1 = new User("Ose","Okoduwa",Role.TEACHER);
        User user2 = new User("Ode","Okoduwa",Role.SENIOR_STUDENT);
        User user3 = new User("Ope","Okoduwa",Role.JUNIOR_STUDENT);
        User user4 = new User("KC","Okafor",Role.TEACHER);
        User user5 = new User("Lade","SEYI",Role.JUNIOR_STUDENT);
        User user6 = new User("Tope","Okoduwa",Role.SENIOR_STUDENT);
        UserUtils userUtils = new UserUtils(libraryUtils);

        userUtils.borrowBook(user1,"Java1");
        userUtils.borrowBook(user2,"Java1");
        userUtils.borrowBook(user3,"Java2");
        userUtils.borrowBook(user1,"Java2");
        userUtils.borrowBook(user6,"Java6");
        userUtils.borrowBook(user5,"Java5");
        userUtils.borrowBook(user3,"Java6");
        userUtils.borrowBook(user4,"Java5");
        userUtils.borrowBook(user1,"Java5");

        libraryUtils.processQueue();


        System.out.println(decaLibrary.getBookOrders());

    }

}

