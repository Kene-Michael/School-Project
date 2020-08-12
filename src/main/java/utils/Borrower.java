package utils;

import models.Book;
import models.User;
//An interface that every class implementing it will define borrowBook and returnBook.
public interface Borrower {
    void borrowBook(User user, String bookId);
    void returnBook(Book book);
}
