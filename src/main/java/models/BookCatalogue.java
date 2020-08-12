package models;

public class BookCatalogue {
    //Fields.
    private int totalNoOfBooks;
    private int availableBooks;
    private Book book;

    //Getters and Setters.
    public int getTotalNoOfBooks() {
        return totalNoOfBooks;
    }

    public void setTotalNoOfBooks(int totalNoOfBooks) {
        this.totalNoOfBooks = totalNoOfBooks;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public void incrementTotalBooks() {
        totalNoOfBooks +=1;
    }
    public void incrementAvailableBooks() {
        availableBooks +=1;
    }
    public void decrementTotalBooks() {
        totalNoOfBooks -=1;
    }
    public void decrementAvailableBooks() {
        availableBooks -=1;
    }


}
