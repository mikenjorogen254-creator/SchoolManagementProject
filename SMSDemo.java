package schoolmanagement;

import java.util.*;

public class SMSDemo {
    public static void main(String[] args) {
        SchoolController controller = new SchoolController();

        Student s1 = new Student("S001", "Alice", "Mwangi");
        Student s2 = new Student("S002", "Bob", "Karanja");
        Student s3 = new Student("S003", "Cyrus", "Njoroge");
        controller.addStudent(s1);
        controller.addStudent(s2);
        controller.addStudent(s3);

        Course c1 = new Course("C101", "Data Structures", 2);
        Course c2 = new Course("C102", "Database Systems", 2);
        controller.addCourse(c1);
        controller.addCourse(c2);

        controller.enqueueCourseRegistration("S001", "C101");
        controller.enqueueCourseRegistration("S002", "C101");
        controller.enqueueCourseRegistration("S003", "C101");
        controller.enqueueCourseRegistration("S003", "C102");
        controller.processRegistrations();

        controller.recordPayment("S001", 5000);
        controller.recordPayment("S002", 5000);

        controller.addBook(new Book("978-0131103627", "The C Programming Language", 2));
        controller.addBook(new Book("978-0262033848", "Introduction to Algorithms", 1));
        controller.borrowBook("S001", "978-0131103627");

        controller.updateStudentGrade("S001", "C101", 3.7);
        controller.updateStudentGrade("S002", "C101", 3.9);
        controller.updateStudentGrade("S003", "C102", 3.5);

        List<StudentPerformance> top = controller.topKPerformers(2);
        System.out.println("\nTop Performers:");
        for (StudentPerformance p : top) {
            System.out.println(p);
        }
    }
}
