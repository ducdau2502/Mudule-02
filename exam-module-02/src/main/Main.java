package main;

import manager.ManagerContact;
import module.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String PATH_NAME = "src/data/contacts.csv";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerContact managerContact = new ManagerContact();
        while (true) {
            try {
                int choice;
                do {
                    System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
                    System.out.println("Chọn chức năng theo số (để tiếp tục)");
                    System.out.println("1. Xem danh bạ");
                    System.out.println("2. Thêm mới");
                    System.out.println("3. Cập Nhật");
                    System.out.println("4. Xoá");
                    System.out.println("5. Tìm kiếm");
                    System.out.println("6. Đọc từ file");
                    System.out.println("7. Ghi ra file");
                    System.out.println("8. Thoát");
                    System.out.print("Chọn chức năng: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            managerContact.displayAll();
                            break;
                        case 2:
                            Contact contact2 = managerContact.addContact();
                            if (contact2 != null) {
                                System.out.println(contact2);
                            } else {
                                System.out.println("Thêm thất bại.");
                            }
                            break;
                        case 3:
                            System.out.println("Nhập số điện thoại cần cập nhật: ");
                            String updatePhoneNumber = scanner.nextLine();
                            Contact contact3 = managerContact.updateContact(updatePhoneNumber);
                            if (contact3 != null) {
                                System.out.println(contact3);
                            } else {
                                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                            }
                            break;
                        case 4:
                            System.out.print("Nhập số điện thoại cần xoá: ");
                            String deletePhoneNumber = scanner.nextLine();
                            Contact contact4 = managerContact.findContact(deletePhoneNumber);
                            if (contact4 != null) {
                                System.out.print("Nhập (Y) để xoá: ");
                                String confirm = scanner.nextLine();
                                if (confirm.equalsIgnoreCase("Y")) {
                                    contact4 = managerContact.deleteContact(deletePhoneNumber);
                                    System.out.println(contact4);
                                } else {
                                    break;
                                }
                            } else {
                                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                            }
                            break;
                        case 5:
                            System.out.print("Nhập số điện thoại hoặc tên cần tim: ");
                            String findString = scanner.nextLine();
                            managerContact.searchContactByNameOrPhone(findString);
                            break;
                        case 6:
                            ArrayList<Contact> contacts = managerContact.readFile(PATH_NAME);
                            for (Contact contact : contacts) {
                                System.out.println(contact);
                            }
                            break;
                        case 7:
                            managerContact.writeFile(managerContact.returnContacts(), PATH_NAME);
                            break;
                        case 8:
                            System.exit(0);
                    }
                } while (choice !=0);
            } catch (Exception e) {
                System.out.println("Không được đâu bạn êi");
            }
        }

    }
}
