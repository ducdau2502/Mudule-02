package manager;

import module.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerContact {
    private static final String PATH_NAME = "src/data/contacts.csv";
    private static final String PHONE_REGEX = "^[(](\\+84)[)][\\s][0-9]{9,}$";
    private static final String EMAIL_REGEX = "^[a-z][a-z0-9]{0,9}@[a-z]+\\.(com|vn)+$";
    ArrayList<Contact> contacts;
    Scanner scanner = new Scanner(System.in);

    public ManagerContact() {
        this.contacts = readFile(PATH_NAME);
    }

    private boolean validateData(String regex, String REGEX) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.find();
    }

    public void writeFile(ArrayList<Contact> contacts, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Contact contact : contacts) {
                bufferedWriter.append(contact.getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getGroup());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getName());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getGender());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getAddress());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getDateOfBirth());
                bufferedWriter.append(",");
                bufferedWriter.append(contact.getEmail());
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Contact> readFile(String path) {
        ArrayList<Contact> contacts = new ArrayList<>();
        File file = new File(path);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                String phoneNumber = strings[0];
                String group = strings[1];
                String name = strings[2];
                String gender = strings[3];
                String address = strings[4];
                String dateOfBirth = strings[5];
                String email = strings[6];

                contacts.add(new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return contacts;
    }

    public ArrayList<Contact> returnContacts() {
        return contacts;
    }

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Kh??ng c?? danh b???");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public Contact addContact() {
        String email;
        String phone;
        System.out.print("Nh???p s??? ??i???n tho???i: ");
        String phoneNumber = scanner.nextLine();
        if (validateData(phoneNumber, PHONE_REGEX)) {
            phone = phoneNumber;
        }else {
            System.out.println("Sai ?????nh d???ng");
            return null;
        }
        System.out.print("Nh???p nh??m: ");
        String group = scanner.nextLine();
        System.out.print("Nh???p t??n: ");
        String name = scanner.nextLine();
        System.out.print("Nh???p gi???i t??nh: ");
        String gender = scanner.nextLine();
        System.out.print("Nh???p ?????a ch???: ");
        String address = scanner.nextLine();
        System.out.print("Nh???p ng??y sinh(dd-mm-yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nh???p email: ");
        String emailAddress = scanner.nextLine();
        if (validateData(emailAddress, EMAIL_REGEX)) {
            email = emailAddress;
        }else {
            System.out.println("Sai ?????nh d???ng");
            return null;
        }
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("S??? ??i???n tho???i b??? tr??ng, m???i ki???m tra l???i !");
                return null;
            }
        }

        Contact contact = new Contact(phone, group, name, gender, address, dateOfBirth, email);
        contacts.add(contact);
        writeFile(contacts, PATH_NAME);
        return contact;
    }

    public Contact updateContact(String updatePhoneNumber) {
        Contact contact = null;

        for (Contact contact1 : contacts) {
            if (contact1.getPhoneNumber().equals(updatePhoneNumber)) {
                contact = contact1;
            }
        }

        if (contact != null) {
            int index = contacts.indexOf(contact);
            System.out.print("Nh???p l???i s??? ??i???n tho???i: ");
            String phoneNumber = scanner.nextLine();
            for (Contact ct : contacts) {
                if (ct.getPhoneNumber().equals(phoneNumber)) {
                    System.out.println("S??? ??i???n tho???i b??? tr??ng, m???i ki???m tra l???i !");
                    return null;
                }
            }
            String email;
            String phone;
            if (validateData(phoneNumber, PHONE_REGEX)) {
                phone = phoneNumber;
            } else {
                System.out.println("Sai ?????nh d???ng");
                return null;
            }
            contact.setPhoneNumber(phone);
            System.out.print("Nh???p lai nh??m: ");
            String group = scanner.nextLine();
            contact.setGroup(group);
            System.out.print("Nh???p l???i t??n: ");
            String name = scanner.nextLine();
            contact.setName(name);
            System.out.print("Nh???p l???i gi???i t??nh: ");
            String gender = scanner.nextLine();
            contact.setGender(gender);
            System.out.print("Nh???p l???i ?????a ch???: ");
            String address = scanner.nextLine();
            contact.setAddress(address);
            System.out.print("Nh???p l???i ng??y sinh: ");
            String dateOfBirth = scanner.nextLine();
            contact.setDateOfBirth(dateOfBirth);
            System.out.print("Nh???p l???i email: ");
            String emailAddress = scanner.nextLine();
            if (validateData(emailAddress, EMAIL_REGEX)) {
                email = emailAddress;
            }else {
                System.out.println("Sai ?????nh d???ng");
                return null;
            }
            contact.setEmail(email);

            contacts.set(index, contact);
            writeFile(contacts, PATH_NAME);
        }

        return contact;
    }

    public Contact deleteContact(String deletePhoneNumber) {
        Contact contact = null;

        for (Contact contact1 : contacts) {
            if (contact1.getPhoneNumber().equals(deletePhoneNumber)) {
                contact = contact1;
            }
        }

        if (contact != null) {
            contacts.remove(contact);
            writeFile(contacts, PATH_NAME);
        }

        return contact;
    }

    public Contact findContact(String findPhoneNumber) {
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (contact1.getPhoneNumber().equals(findPhoneNumber)) {
                contact = contact1;
            }
        }
        return contact;
    }

    public boolean validatePhoneOrName(String keyword, String regex) {
        keyword = keyword.toLowerCase();
        String PHONE_NAME_REGEX = ".*" + keyword + ".*";
        Pattern pattern = Pattern.compile(PHONE_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex.toLowerCase());
        return matcher.matches();
    }

    public void searchContactByNameOrPhone(String keyword) {
        ArrayList<Contact> contactList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (validatePhoneOrName(keyword, contact.getPhoneNumber()) || validatePhoneOrName(keyword, contact.getName())) {
                contactList.add(contact);
            }
        }
        if (contactList.isEmpty()) {
            System.out.println("Kh??ng t??m th???y danh b??? v???i t??? kh??a tr??n.");
        } else {
            System.out.println("Danh b??? c???n t??m:");
            contactList.forEach(System.out::println);
        }
    }
}
