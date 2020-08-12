package utils;

import models.Book;
import models.BookOrder;
import models.Library;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {
    Library decaLibrary;
    LibraryUtils decaLibraryUtils;

    @BeforeEach
    void setup() {
        decaLibrary = new Library("DecaLibrary");
        decaLibraryUtils = new LibraryUtils(decaLibrary);
    }

    @Test
    void offer() {
        User obrien = new User("Obrien","Longe",Role.JUNIOR_STUDENT);
        User chibueze = new User("Chibueze","Eziokwu",Role.TEACHER);
        User adekan = new User("Sola","Adekan",Role.SENIOR_STUDENT);
        User kenechukwu = new User("Okafor","Kenechukwu",Role.JUNIOR_STUDENT);
        User daro = new User("Daro","Odohi",Role.TEACHER);
        Book book1 = decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        Book book2 = decaLibraryUtils.createBook("Intro to OOP","David","Java",47,"Java2");
        Book book3 = decaLibraryUtils.createBook("Intro to COLLECTIONS","Uju","Java",233,"Java3");
        decaLibraryUtils.createBookOrder(obrien,book1.getBookId());
        decaLibraryUtils.createBookOrder(chibueze,book1.getBookId());
        decaLibraryUtils.createBookOrder(adekan,book2.getBookId());
        decaLibraryUtils.createBookOrder(kenechukwu,book1.getBookId());
        decaLibraryUtils.createBookOrder(adekan,book3.getBookId());
        decaLibraryUtils.createBookOrder(daro,book3.getBookId());
        MyPriorityQueue listOfOrders = decaLibrary.getBookOrders();
        BookOrder Order1 = listOfOrders.poll();
        BookOrder Order2 = listOfOrders.poll();
        BookOrder Order3 = listOfOrders.poll();
        BookOrder Order4 = listOfOrders.poll();
        BookOrder Order5 = listOfOrders.poll();
        BookOrder Order6 = listOfOrders.poll();

        assertAll(
                () -> assertEquals(chibueze.getFirstName(),Order1.getUser().getFirstName()),
                () -> assertEquals(book1.getBookId(),Order1.getBookId()),
                () -> assertEquals(obrien.getFirstName(),Order2.getUser().getFirstName()),
                () -> assertEquals(book1.getBookId(),Order2.getBookId()),
                () -> assertEquals(adekan.getFirstName(),Order3.getUser().getFirstName()),
                () -> assertEquals(book2.getBookId(),Order3.getBookId()),
                () -> assertEquals(kenechukwu.getFirstName(),Order4.getUser().getFirstName()),
                () -> assertEquals(book1.getBookId(),Order4.getBookId()),
                () -> assertEquals(daro.getFirstName(),Order5.getUser().getFirstName()),
                () -> assertEquals(book3.getBookId(),Order5.getBookId()),
                () -> assertEquals(adekan.getFirstName(),Order6.getUser().getFirstName()),
                () -> assertEquals(book3.getBookId(),Order6.getBookId())
        );

    }
}