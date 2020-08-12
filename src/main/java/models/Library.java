package models;

import utils.LibraryUtils;
import utils.MyPriorityQueue;

import java.util.*;

public class Library {
    //Fields
    private String name;
    private Map<String,BookCatalogue> books = new HashMap<>();
    private MyPriorityQueue bookOrders = new MyPriorityQueue();
    private List<BookOrder> orderHistory = new ArrayList<>();

    //Constructor
    public Library(String name) {
        this.name = name;
    }

    //Getters and Setters.
    public String getName() {
        return name;
    }

    public Map<String, BookCatalogue> getBooks() {
        return books;
    }

    public MyPriorityQueue getBookOrders() {
        return bookOrders;
    }

    public List<BookOrder> getOrderHistory() {
        return orderHistory;
    }
}
