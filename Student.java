package schoolmanagement;

import java.util.*;

public class Student {
    String id;
    String firstName;
    String lastName;
    Map<String, Double> grades;
    boolean feeCleared;

    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new HashMap<>();
        this.feeCleared = false;
    }

    public double getGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades.values()) sum += g;
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return id + " - " + firstName + " " + lastName + " (GPA: " + String.format("%.2f", getGPA()) + ")";
    }
}
