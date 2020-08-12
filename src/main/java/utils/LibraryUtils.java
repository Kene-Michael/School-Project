package utils;

import models.*;
import java.util.Map;

public class LibraryUtils {
    //Instance of Library to access library fields.
    private Library library;

    public LibraryUtils(Library library) {
        this.library = library;
    }

    /**
     * A method that takes in a user and bookId, checks if the book exists in the library , and if it does,
     * create a book order from the fields and adds the other to the priority queue.
     * @param user
     * @param bookId
     * @return boolean
     */
    public boolean createBookOrder(User user, String bookId) {
        if(library.getBooks().containsKey(bookId)) {
            BookOrder bookOrder = new BookOrder(user,bookId);
            library.getBookOrders().offer(bookOrder);
        } else {
            System.out.println("We do not have this book!!!");
        }
        return true;
    }

    /**
     * A method that takes in fields required to create a book, creates a book from them and calls the addBook method
     * to add the book to the Library.
     * @param name
     * @param author
     * @param category
     * @param noOfPages
     * @param bookId
     */
    public void createBook(String name, String author, String category, int noOfPages, String bookId) {
        Book book = new Book(name,author,category,noOfPages,bookId);
        addBook(book);
    }

    /**
     * This method takes in a book, checks if this book has a catalogue in the library and if yes, increments the number
     * of that book available. If the book does not have a catalogue, it creates a catalogue for the book and increments
     * the number of books available.
     * @param book
     */
    public void addBook(Book book) {
        BookCatalogue bookCatalogue = library.getBooks().get(book.getBookId());
        if (bookCatalogue == null) {
            bookCatalogue = new BookCatalogue();
            bookCatalogue.setBook(book);
            library.getBooks().put(book.getBookId(),bookCatalogue);
        }
        bookCatalogue.incrementAvailableBooks();
    }

    /**
     * This method takes in a bookId and checks if the book has a catalogue in the Library. If the catalogue exists and the
     * number of available books is not 0, return book and decrement the number of books available else return Book is not
     * available.
     * @param bookId
     * @return Book
     */
    public Book getBook(String bookId) {
        BookCatalogue bookCatalogue = library.getBooks().get(bookId);
        if (bookCatalogue == null || bookCatalogue.getAvailableBooks() < 1) {
            System.out.println("This book is not available!!");
            return null;
        }
        bookCatalogue.decrementAvailableBooks();
//        library.getOrderHistory().add(library.getBookOrders().peek());
        return bookCatalogue.getBook();
    }

    /**
     * This method processes the priorityQueue and gets books from the order based on priority.
     */
    public void processQueue() {
        while(library.getBookOrders().size() > 0) {
            getBook(library.getBookOrders().poll().getBookId());
        }
    }

}