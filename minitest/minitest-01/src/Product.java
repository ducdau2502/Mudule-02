public class Product {
    private int code;
    private String name;
    private long price;
    private String type;
    private final String unitMoney = "USD";

    public Product(int code, String name, long price, String type) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitMoney() {
        return unitMoney;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + getCode() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + " " + getUnitMoney() +
                ", type='" + getType() + '\'' +
                '}';
    }
}
