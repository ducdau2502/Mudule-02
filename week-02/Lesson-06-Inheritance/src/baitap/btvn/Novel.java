package baitap.btvn;

public class Novel extends Book {
    private String author;

    public Novel() {
    }

    public Novel(String name, long price, int quantity, String publicDate, String author) {
        super(name, price, quantity, publicDate);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Novel: " +
                "author = " + author + super.toString();
    }
}
