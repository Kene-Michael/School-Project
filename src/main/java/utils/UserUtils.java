package utils;

import models.Book;
import models.Library;
import models.User;

public class UserUtils implements Borrower {
    //An instance of LibraryUtils to enable use of its methods.
    private LibraryUtils libraryUtils;

    public UserUtils(LibraryUtils libraryUtils) {
        this.libraryUtils = libraryUtils;
    }

    /**
     * A method that takes in a user and bookId and calls the createBookOrder method in the LibraryUtils Class.
     * @param user
     * @param bookId
     */
    @Override
    public void borrowBook(User user,String bookId) {
        libraryUtils.createBookOrder(user,bookId);
    }

    /**
     * A method that takes in a book and call the addBook method in LibraryUtils class.
     * @param book
     */
    @Override
    public void returnBook(Book book) {
        libraryUtils.addBook(book);
    }

}
