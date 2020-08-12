package utils;

import models.Book;
import models.Library;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserUtilsTest {
    Library decaLibrary;
    LibraryUtils decaLibraryUtils;
    UserUtils userUtils;

    @BeforeEach
    void setUp() {
        decaLibrary = new Library("DecaLibrary");
        decaLibraryUtils = new LibraryUtils(decaLibrary);
        userUtils = new UserUtils(decaLibraryUtils);
    }

    @Test
    void borrowBook() {
        decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
        User obrien = new User("Obrien","Longe",Role.SENIOR_STUDENT);
        userUtils.borrowBook(obrien,"Java1");
        String expected = "Java1";
        String actual = decaLibrary.getBookOrders().peek().getBookId();
        assertEquals(expected,actual);
    }

    @Test
    void returnBook() {
        Book book = decaLibraryUtils.createBook("Intro to Java","Daro","Java",465,"Java1");
//        User obrien = new User("Obrien","Longe",Role.SENIOR_STUDENT);
        userUtils.returnBook(book);
        int expected = 2;
        int actual = decaLibrary.getBooks().get(book.getBookId()).getAvailableBooks();
        assertEquals(expected,actual);
    }
}