package schoolmanagement;

import java.time.LocalDate;

public class FeeRecord {
    String transactionId;
    String studentId;
    double amount;
    LocalDate date;

    public FeeRecord(String transactionId, String studentId, double amount) {
        this.transactionId = transactionId;
        this.studentId = studentId;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return transactionId + ": " + studentId + " paid " + amount + " on " + date.toString();
    }
}
