package schoolmanagement;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SchoolController {
    Map<String, Student> studentRegistry = new HashMap<>();
    Map<String, Course> courses = new HashMap<>();
    CircularQueue<RegistrationRequest> registrationQueue = new CircularQueue<>(50);
    TreeMap<String, FeeRecord> feeRecords = new TreeMap<>();
    Map<String, Book> books = new HashMap<>();
    Stack<String> borrowStack = new Stack<>();
    PriorityQueue<StudentPerformance> performancePQ = new PriorityQueue<>();
    AtomicInteger txnCounter = new AtomicInteger(1000);

    public boolean addStudent(Student s) {
        if (studentRegistry.containsKey(s.id)) return false;
        studentRegistry.put(s.id, s);
        return true;
    }

    public void addCourse(Course c) {
        courses.put(c.id, c);
    }

    public void enqueueCourseRegistration(String studentId, String courseId) {
        RegistrationRequest r = new RegistrationRequest(studentId, courseId);
        registrationQueue.enqueue(r);
    }

    public void processRegistrations() {
        while (!registrationQueue.isEmpty()) {
            RegistrationRequest r = registrationQueue.dequeue();
            Course c = courses.get(r.courseId);
            if (c == null) continue;
            boolean added = c.addStudent(r.studentId);
            if (added) System.out.println("Enrolled " + r.studentId + " to " + c.id);
            else System.out.println("Waitlisted " + r.studentId + " for " + c.id);
        }
    }

    public String recordPayment(String studentId, double amount) {
        String txnId = "TXN" + txnCounter.incrementAndGet();
        FeeRecord fr = new FeeRecord(txnId, studentId, amount);
        feeRecords.put(txnId, fr);
        Student s = studentRegistry.get(studentId);
        if (s != null) s.feeCleared = true;
        return txnId;
    }

    public void addBook(Book b) {
        books.put(b.isbn, b);
    }

    public boolean borrowBook(String studentId, String isbn) {
        Book b = books.get(isbn);
        if (b == null || b.availableCopies <= 0) return false;
        b.availableCopies -= 1;
        borrowStack.push(isbn + ":" + studentId);
        return true;
    }

    public void updateStudentGrade(String studentId, String courseId, double grade) {
        Student s = studentRegistry.get(studentId);
        if (s != null) s.grades.put(courseId, grade);
    }

    public List<StudentPerformance> topKPerformers(int k) {
        PriorityQueue<StudentPerformance> temp = new PriorityQueue<>();
        for (Student s : studentRegistry.values()) {
            temp.add(new StudentPerformance(s.id, s.getGPA()));
        }
        List<StudentPerformance> top = new ArrayList<>();
        for (int i = 0; i < k && !temp.isEmpty(); i++) {
            top.add(temp.poll());
        }
        return top;
    }
}
