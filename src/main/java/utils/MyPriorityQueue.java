package utils;

import models.BookOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

//An implementation of PriorityQueue class using a List.
public class MyPriorityQueue {
    private ArrayList<BookOrder> queue = new ArrayList<BookOrder>();

    //Boolean for different implementations of priority.
    private boolean mode;

    public MyPriorityQueue() {
        this(true);
    }

    public MyPriorityQueue (boolean mode) {
      this.mode = mode;
    }

    /**
     * This method takes in a book order, checks if the list is empty and if it is, add the bookOrder to the list. If the
     * list is not empty, it sorts the list based on priority with Teacher role coming first, Senior Student role second
     * and Junior student role coming later when they all have a book order for the same book and else treats the list as
     * first come first serve list.
     * @param bookOrder
     * @return
     */
    public boolean offer(BookOrder bookOrder) {
        if(!mode) return queue.add(bookOrder);
        if (mode) {
            int size = queue.size();
            if(size == 0) {
                queue.add(bookOrder);
            return true;
            }
            for (int i = 0; i < size; i++) {
                if (queue.get(i).getBookId().equals(bookOrder.getBookId())) {
                    if (bookOrder.getUser().getRole() == Role.TEACHER &&
                            (queue.get(i).getUser().getRole() == Role.JUNIOR_STUDENT
                                    || queue.get(i).getUser().getRole() == Role.SENIOR_STUDENT)) {
                        queue.add(i , bookOrder);
                        return true;
                    } else if ((bookOrder.getUser().getRole() == Role.SENIOR_STUDENT) &&
                            queue.get(i).getUser().getRole() == Role.JUNIOR_STUDENT) {
                        queue.add(i, bookOrder);
                        return true;
                    }
                }

            }
            queue.add(bookOrder);
        }
            return true;
    }

    /**
     * This method removes the first element of the queue and returns it.
     * @return
     */
    public BookOrder poll() {
        return queue.remove(0);
    }

    /**
     * This methods return the first element in the queue.
     * @return
     */
    public BookOrder peek() {
        return queue.get(0);
    }

    /**
     * This method returns the length of the queue.
     * @return
     */
    public int size () {
        return queue.size();
    }

    @Override
    public String toString() {
        return "queue=" + queue;
    }
}
