package schoolmanagement;

import java.util.*;

public class Course {
    String id;
    String title;
    int capacity;
    Set<String> enrolled;
    Queue<String> waitlist;

    public Course(String id, String title, int capacity) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
        this.enrolled = new LinkedHashSet<>();
        this.waitlist = new LinkedList<>();
    }

    public boolean addStudent(String studentId) {
        if (enrolled.size() < capacity) {
            enrolled.add(studentId);
            return true;
        } else {
            waitlist.offer(studentId);
            return false;
        }
    }

    public void dropStudent(String studentId) {
        enrolled.remove(studentId);
        if (!waitlist.isEmpty()) {
            String next = waitlist.poll();
            enrolled.add(next);
        }
    }

    @Override
    public String toString() {
        return id + " - " + title + " (cap: " + capacity + ", enrolled: " + enrolled.size() + ")";
    }
}
