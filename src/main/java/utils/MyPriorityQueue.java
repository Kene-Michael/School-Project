package utils;

import models.BookOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class MyPriorityQueue {
    private ArrayList<BookOrder> queue = new ArrayList<BookOrder>();
    private boolean mode;

    public MyPriorityQueue() {
        this(true);
    }

    public MyPriorityQueue (boolean mode) {
      this.mode = mode;
    }

    public BookOrder poll() {
        return queue.remove(0);
    }

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
            System.out.println(queue);
            return true;
    }
    public BookOrder peek() {
        return queue.get(0);
    }

    public ListIterator<BookOrder> listIterator () {
        return queue.listIterator();
    }

    public Iterator<BookOrder> iterator () {
        return queue.iterator();
    }

    public int size () {
        return queue.size();
    }

    @Override
    public String toString() {
        return "queue=" + queue;
    }
}
