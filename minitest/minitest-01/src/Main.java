import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        Product[] products = new Product[quantity];

        createArray(scanner, products);

        FindProduct(scanner, products);

        TotalPrice(products);

        EditProduct(scanner, products);

        Product[] result = DeleteProduct(scanner, products);

        for (Product k : products) {
            System.out.println(k);

        }
        for (Product k : result) {
            System.out.println(k);
        }

    }

    private static Product[] DeleteProduct(Scanner scanner, Product[] products) {
        Product[] result = new Product[(products.length - 1)];
        System.out.print("Nhập mã sản phẩm muốn xoá: ");
        int codeProduct = scanner.nextInt();
        for (int i = 0; i < products.length; i++) {
            int c = 0;
            if (codeProduct != products[i].getCode()) {
                result[c] = products[i];
                c++;
            }
        }
        return result;
    }

    private static void EditProduct(Scanner scanner, Product[] products) {
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

    private static void TotalPrice(Product[] products) {
        long sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }

        System.out.println("Tổng giá các sản phẩm là: " + sum);
    }

    private static void FindProduct(Scanner scanner, Product[] products) {
        System.out.print("Nhập tên sản phẩm muốn tìm: ");
        String nameProduct = scanner.nextLine();
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (nameProduct.equals(products[i].getName())) {
                flag = true;
                index = i;
                break;
            }
        }
        if (flag) {
            System.out.println(products[index].toString());
        } else {
            System.out.println("Không tìm thấy sản phầm nào");
        }
    }

    public static void createArray(Scanner scanner, Product[] products) {

        for (int i = 0; i < products.length; i++) {
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
