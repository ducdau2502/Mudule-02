package exercise.managerproduct;

import java.io.Serializable;

public class Product implements Serializable {
    private static int VALUE = 1;
    private int code;
    private String name;
    private String brand;
    private double price;

    public Product() {
    }

    public Product(String name, String brand, double price) {
        this.code = VALUE++;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product {" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
