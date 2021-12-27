package exercise.managerproduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("ip11", "apple", 20000));
        products.add(new Product("ip10", "apple", 19000));
        products.add(new Product("ip9", "apple", 18000));
        products.add(new Product("ip8", "apple", 17000));
        products.add(new Product("ip7", "apple", 160000));
        products.add(new Product("ss", "samsung", 210000));
        String pathName = "src/exercise/managerproduct/products";

        writeBinaryFile(pathName, products);

        List<Product> studentDataFromFile = readBinaryFile(pathName);
        for (Product product : studentDataFromFile){
            System.out.println(product);
        }

    }

    public static void writeBinaryFile(String pathName, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(pathName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException ios) {
            ios.printStackTrace();
        }
    }

    public static List<Product> readBinaryFile(String pathName) {
        List<Product> products = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(pathName);
            ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
