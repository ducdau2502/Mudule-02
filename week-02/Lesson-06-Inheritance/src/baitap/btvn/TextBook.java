package baitap.btvn;

public class TextBook extends Book {
    private String type;

    public TextBook() {
    }

    public TextBook(String name, long price, int quantity, String publicDate, String type) {
        super(name, price, quantity, publicDate);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TextBook: " +
                "type = " + type + super.toString();
    }
}
