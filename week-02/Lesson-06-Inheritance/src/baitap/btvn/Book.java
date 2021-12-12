package baitap.btvn;

public class Book {
    private String name;
    private long price;
    private int quantity;
    private String publicDate;

    public Book() {
    }

    public Book(String name, long price, int quantity, String publicDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.publicDate = publicDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public String toString() {
        return ", name = " + name +
                ", price = " + price +
                ", quantity = " + quantity +
                ", publicDate = " + publicDate;
    }

}
