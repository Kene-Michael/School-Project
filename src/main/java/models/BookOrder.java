package models;

public class BookOrder {
    //Fields
    private User user;
    private String bookId;

    //Constructor
    public BookOrder(User user, String bookId) {
        this.user = user;
        this.bookId = bookId;
    }

    //Getters and Setters.
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    // Method overrides toString method.
    @Override
    public String toString() {
        return " user=" + user.getRole() +
                "--bookId='" + bookId + "'";
    }
}
