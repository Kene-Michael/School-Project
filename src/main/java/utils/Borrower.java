package utils;

import models.Book;
import models.User;

public interface Borrower {
    void borrowBook(User user, String bookId);
    void returnBook(Book book);
}
