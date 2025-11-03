package schoolmanagement;

public class RegistrationRequest {
    String studentId;
    String courseId;
    long requestTime;

    public RegistrationRequest(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.requestTime = System.currentTimeMillis();
    }
}
