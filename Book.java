package schoolmanagement;

public class Book {
    String isbn;
    String title;
    int totalCopies;
    int availableCopies;

    public Book(String isbn, String title, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    @Override
    public String toString() {
        return isbn + " - " + title + " (avail: " + availableCopies + ")";
    }
}
