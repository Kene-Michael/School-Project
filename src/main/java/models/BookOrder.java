package models;

public class BookOrder {
    private User user;
    private String bookId;

    public BookOrder(User user, String bookId) {
        this.user = user;
        this.bookId = bookId;
    }

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

    @Override
    public String toString() {
        return " user=" + user.getRole() +
                "--bookId='" + bookId + "'";
    }
}
