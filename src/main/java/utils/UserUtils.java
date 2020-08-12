package utils;

import models.Book;
import models.Library;
import models.User;

public class UserUtils implements Borrower {
    private LibraryUtils libraryUtils;

    public UserUtils(LibraryUtils libraryUtils) {
        this.libraryUtils = libraryUtils;
    }


    @Override
    public void borrowBook(User user,String bookId) {
        libraryUtils.createBookOrder(user,bookId);
    }

    @Override
    public void returnBook(Book book) {
        libraryUtils.addBook(book);
    }

}
