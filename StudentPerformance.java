package schoolmanagement;

public class StudentPerformance implements Comparable<StudentPerformance> {
    String studentId;
    double score;

    public StudentPerformance(String studentId, double score) {
        this.studentId = studentId;
        this.score = score;
    }

    @Override
    public int compareTo(StudentPerformance other) {
        return Double.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return studentId + " → " + String.format("%.2f", score);
    }
}
