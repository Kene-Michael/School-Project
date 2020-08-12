package utils;

import models.Book;
import models.Library;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUtilsTest {
    Library decaLibrary;
    LibraryUtils decaLibraryUtils;

    @BeforeEach
    void setup() {
        decaLibrary = new Library("DecaLibrary");
        decaLibraryUtils = new LibraryUtils(decaLibrary);
    }

    @Test
    void createBookOrder() {
        User obrien = new User("Obrien","Longe",Role.SENIOR_STUDENT);
        Book book = decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        decaLibraryUtils.createBookOrder(obrien,book.getBookId());
        String actual = decaLibrary.getBookOrders().peek().getBookId();
        String expected = "Java1";
        assertEquals(actual,expected);
    }

    @Test
    void createBook() {
        decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        int actual = decaLibrary.getBooks().get("Java1").getAvailableBooks();
        int expected = 1;
        assertEquals(actual,expected);
    }

    @Test
    void addBook() {
        Book book = decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        decaLibraryUtils.addBook(book);
        int actual = decaLibrary.getBooks().get("Java1").getAvailableBooks();
        int expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    void getBook() {
        decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        Book book = decaLibraryUtils.getBook("Java1");
        String actual = book.getName();
        String expected = "Intro to Java";
        assertEquals(expected,actual);
    }

    @Test
    void processQueue() {
        User obrien = new User("Obrien","Longe",Role.SENIOR_STUDENT);
        User chibueze = new User("Chibueze","Eziokwu",Role.SENIOR_STUDENT);
        User adekan = new User("Sola","Adekan",Role.SENIOR_STUDENT);
        Book book1 = decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        Book book2 = decaLibraryUtils.createBook("Intro to OOP","David","Java",47,"Java2");
        Book book3 = decaLibraryUtils.createBook("Intro to COLLECTIONS","Uju","Java",233,"Java3");
        decaLibraryUtils.createBookOrder(obrien,book1.getBookId());
        decaLibraryUtils.createBookOrder(chibueze,book2.getBookId());
        decaLibraryUtils.createBookOrder(adekan,book3.getBookId());
        decaLibraryUtils.processQueue();
        int expected = 0;
        int actual = decaLibrary.getBookOrders().size();
        assertEquals(expected,actual);
    }
}