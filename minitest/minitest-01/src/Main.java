import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        Product[] products = new Product[quantity];

        createArray(scanner, products);

        for (Product k : products) {
            System.out.println(k);
        }

        findProduct(scanner, products);

        totalPrice(products);

        editProduct(scanner, products);

        Product[] result = deleteProduct(scanner, products);

        for (Product k : result) {
            System.out.println(k);
        }

    }

    private static Product[] deleteProduct(Scanner scanner, Product[] products) {
        System.out.print("Nhập mã sản phẩm muốn xoá: ");
        int codeProduct = scanner.nextInt();

        int count = 0;
        for (Product k: products) {
            if (codeProduct == k.getCode()) {
                count++;
            }
        }

        Product[] result = new Product[(products.length - count)];
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (codeProduct != products[i].getCode()) {
                result[index] = products[i];
                index++;
            }
        }
        return result;
    }

    private static void editProduct(Scanner scanner, Product[] products) {
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int codeProduct = scanner.nextInt();
        for (int i = 0; i < products.length; i++) {
            if (codeProduct == products[i].getCode()) {
                scanner.nextLine();
                System.out.print("Nhập lại tên sản phẩm: ");
                String name = scanner.nextLine();
                System.out.print("Nhập lại giá sản phẩm: ");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nhập lại loại sản phẩm: ");
                String type = scanner.nextLine();

                products[i].setName(name);
                products[i].setPrice(price);
                products[i].setType(type);
            }
        }
    }

    private static void totalPrice(Product[] products) {
        long sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }

        System.out.println("Tổng giá các sản phẩm là: " + sum);
    }

    private static void findProduct(Scanner scanner, Product[] products) {
        System.out.print("Nhập tên sản phẩm muốn tìm: ");
        String nameProduct = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < products.length; i++) {
            if (nameProduct.equals(products[i].getName())) {
                System.out.println(products[i].toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phầm nào");
        }
    }

    public static void createArray(Scanner scanner, Product[] products) {

        for (int i = 0; i < products.length; i++) {
            System.out.println("Nhập sản phẩm thứ: " + (i + 1));
            System.out.print("Nhập mã sản phẩm: ");
            int code = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập loại sản phẩm: ");
            String type = scanner.nextLine();
            products[i] = new Product(code, name, price, type);
        }
    }
}
