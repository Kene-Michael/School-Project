package models;

import utils.Borrower;
import utils.Role;

import java.util.HashSet;

public class User extends Person {
    //Constructor
    public User(String firstName, String lastname, Role role) {
        super(firstName, lastname, role);
    }

}
