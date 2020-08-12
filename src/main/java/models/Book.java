package models;

public class Book {
    private Library library;
    private String name;
    private String author;
    private String category;
    private int noOfPages;
    private String bookId;

    public Book(String name, String author, String category, int noOfPages, String bookId) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.noOfPages = noOfPages;
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "name ='" + name + "' ";
    }
}
