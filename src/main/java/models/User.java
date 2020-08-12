package models;

import utils.Borrower;
import utils.Role;

import java.util.HashSet;

public class User extends Person {
    private HashSet<String> booksBorrowed = new HashSet<>();

    public User(String firstName, String lastname, Role role) {
        super(firstName, lastname, role);
    }
    public HashSet<String> getBooksBorrowed() {
        return booksBorrowed;
    }
}
