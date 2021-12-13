package baitap.btvn;

import java.util.Scanner;

public class ManagerBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = createBookList(scanner);

        displayMenu(scanner, books);

    }

    private static void displayMenu(Scanner scanner, Book[] books) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu bar");
            System.out.println("1. In danh sách");
            System.out.println("2. In tổng giá tiền");
            System.out.println("3. Tìm sách có giá cao nhất");
            System.out.println("4. Tìm sách có giá thấp nhất");
            System.out.println("5. Tìm sách theo loại và tác giả");
            System.out.println("6. In giá tiền trung bình");
            System.out.println("7. In sách giáo khoa");
            System.out.println("8. In tiểu thuyết");
            System.out.println("9. Tìm sách theo khoảng giá");
            System.out.println("10. Tìm sách theo giá");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printBookList(books);
                    break;
                case 2:
                    totalPrice(books);
                    break;
                case 3:
                    totalMax(books);
                    break;
                case 4:
                    totalMin(books);
                    break;
                case 5:
                    findBook(scanner, books);
                    break;
                case 6:
                    averagerPrice(books);
                    break;
                case 7:
                    for (Book b : books) {
                        if (b instanceof TextBook) {
                            TextBook textBook = (TextBook) b;
                            System.out.println(textBook);
                        }
                    }
                    break;
                case 8:
                    for (Book b : books) {
                        if (b instanceof Novel) {
                            Novel novel = (Novel) b;
                            System.out.println(novel);
                        }
                    }
                    break;
                case 9:
                    findRangePrice(scanner, books);
                    break;
                case 10:
                    findPriceBook(scanner, books);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice");
            }
        }
    }

    private static void findPriceBook(Scanner scanner, Book[] books) {
        System.out.print("Nhập giá muốn tìm: ");
        long price = scanner.nextLong();
        boolean flag = false;
        for (Book book : books) {
            if (book.getPrice() == price) {
                System.out.println(book);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sách có giá " + price);
        }
    }

    private static void findRangePrice(Scanner scanner, Book[] books) {
        System.out.println("Nhập khoảng giá muốn tìm");
        System.out.print("Nhập giá thấp: ");
        long lowerPrice = scanner.nextLong();
        System.out.print("Nhập giá cao: ");
        long higherPrice = scanner.nextLong();
        if (lowerPrice <= higherPrice) {
            for (Book book : books) {
                if (book.getPrice() >= lowerPrice && book.getPrice() <= higherPrice) {
                    System.out.println(book);
                }
            }
        } else {
            System.out.println("Nhập lại khoảng giá muốn tìm");
            System.out.print("Nhập giá thấp: ");
            lowerPrice = scanner.nextLong();
            System.out.print("Nhập giá cao: ");
            higherPrice = scanner.nextLong();
        }
    }

    private static void averagerPrice(Book[] books) {
        long average = 0;
        for (Book k : books) {
            average += k.getPrice();
        }
        average = (average / books.length);
        System.out.println("Giá trung bình: " + average);
    }

    private static void findBook(Scanner scanner, Book[] books) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Chọn loại sách muốn in");
            System.out.println("1. Sách giáo khoa");
            System.out.println("2. Tiểu thuyết");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findTypeBook(scanner, books);
                    break;
                case 2:
                    findAuthorBook(scanner, books);
                    break;
                default:
                    System.out.println("No choice!!!");
            }
        }
    }

    private static void findAuthorBook(Scanner scanner, Book[] books) {
        System.out.print("Nhập tên tác giả muốn in: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        boolean flag = false;
        for (Book b : books) {
            if (b instanceof Novel) {
                Novel book = (Novel) b;
                if (book.getAuthor().equals(author)) {
                    System.out.println(book);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sách có thể loại " + author);
        }
    }

    private static void findTypeBook(Scanner scanner, Book[] books) {
        System.out.print("Nhập thể loại sách muốn in: ");
        scanner.nextLine();
        String type = scanner.nextLine();
        boolean flag = false;
        for (Book b : books) {
            if (b instanceof TextBook) {
                TextBook book = (TextBook) b;
                if (book.getType().equals(type)) {
                    System.out.println(book);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sách có thể loại " + type);
        }
    }

    private static void totalMin(Book[] books) {
        long minPrice = books[0].getPrice();
        int index = 0;
        for (int i = 1; i < books.length; i++) {
            if (minPrice > books[i].getPrice()) {
                minPrice = books[i].getPrice();
                index = i;
            }
        }
        System.out.println(books[index]);
    }

    private static void totalMax(Book[] books) {
        long maxPrice = books[0].getPrice();
        int index = 0;
        for (int i = 1; i < books.length; i++) {
            if (maxPrice < books[i].getPrice()) {
                maxPrice = books[i].getPrice();
                index = i;
            }
        }
        System.out.println(books[index]);
    }

    private static void totalPrice(Book[] books) {
        long sum = 0;
        for (Book b : books) {
            sum += b.getPrice() * b.getQuantity();
        }
        System.out.println("tổng giá sách là : " + sum);
    }

    private static void printBookList(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static Book[] createBookList(Scanner scanner) {
        System.out.print("Nhập vào số lượng sách: ");
        int quantity = scanner.nextInt();
        Book[] books = new Book[quantity];

        int i = 0;
        while (i < books.length) {
            System.out.println("1. Nhập vào sách giáo khoa");
            System.out.println("2. Nhập vào tiểu thuyết");
            System.out.println("3. Nhập vào sách thường");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Nhập vào tên sách: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập vào giá: ");
                    long price = scanner.nextLong();
                    System.out.print("Nhập vào số lượng: ");
                    int quantityBook = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập vào ngày xuất bản: ");
                    String publicDate = scanner.nextLine();
                    System.out.print("Nhập vào thể loại: ");
                    String type = scanner.nextLine();

                    TextBook textBook = new TextBook(name, price, quantityBook, publicDate, type);
                    Book book = (Book) textBook;
                    books[i] = book;
                    i++;

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Nhập vào tên sách: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Nhập vào giá: ");
                    long price1 = scanner.nextLong();
                    System.out.print("Nhập vào số lượng: ");
                    int quantityBook1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập vào ngày xuất bản: ");
                    String publicDate1 = scanner.nextLine();
                    System.out.print("Nhập vào tên tác giả: ");
                    String author = scanner.nextLine();

                    Novel novel = new Novel(name1, price1, quantityBook1, publicDate1, author);
                    Book book1 = novel;
                    books[i] = book1;
                    i++;

                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Nhập vào tên sách: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Nhập vào giá: ");
                    long price2 = scanner.nextLong();
                    System.out.print("Nhập vào số lượng: ");
                    int quantityBook2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập vào ngày xuất bản: ");
                    String publicDate2 = scanner.nextLine();

                    Book book2 = new Book(name2, price2, quantityBook2, publicDate2);
                    books[i] = book2;
                    i++;

                    break;
            }
        }
        return books;
    }
}
