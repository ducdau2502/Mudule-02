package main;

import IOfiles.IOFile;
import manager.ManagerComputer;
import manager.ManagerService;
import module.Computer;
import module.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainComputer {
    private final IOFile<Service> serviceIOFile = new IOFile<>();
    private final ArrayList<Service> services = serviceIOFile.readFromFile(PATH_Services);
    private static final String PATH_Services = "src/database/services";
    private final Scanner scanner = new Scanner(System.in);
    ManagerComputer managerComputer = new ManagerComputer();
    ManagerService managerService = new ManagerService();

    public MainComputer() {
    }


    public void runMainComputer() {
        int choice;
        boolean flag = true;
        while (flag) {
            try {
                do {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t##===============================QUẢN LÝ PHÒNG MÁY===============================##");
                    System.out.println("\t\t\t\t\t\t\t|| 1. Hiển thị danh sách máy          || 7. Chỉnh sửa tính tiền theo giờ         ||");
                    System.out.println("\t\t\t\t\t\t\t|| 2. Thêm 1 máy mới                  || 8. Tính tiền                            ||");
                    System.out.println("\t\t\t\t\t\t\t|| 3. Sửa đổi thông tin máy           || 9. Doanh thu theo thời gian             ||");
                    System.out.println("\t\t\t\t\t\t\t|| 4. Xóa 1 máy                       || 10. Tổng doanh thu                      ||");
                    System.out.println("\t\t\t\t\t\t\t|| 5. Thêm dịch vụ                    ||                                         ||");
                    System.out.println("\t\t\t\t\t\t\t|| 6. Hiển thị tất cả dịch vụ         || 0. Quay lại                             ||");
                    System.out.println("\t\t\t\t\t\t\t##=====================================*****=====================================##");
                    System.out.print("\t\t\t\t\t\t\tNhập vào lựa chọn của bạn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            displayComputer();
                            break;
                        case 2:
                            Computer computer = managerComputer.addComputer();
                            if (computer != null) {
                                System.out.println("Tạo máy " + computer.getCode() + " thành công");
                            } else {
                                System.out.println("Tạo tài khoản thất bại");
                            }
                            break;
                        case 3:
                            managerComputer.displayAllComputer();
                            updateComputer();
                            break;
                        case 4:
                            managerComputer.displayAllComputer();
                            deleteComputer();
                            break;
                        case 5:
                            Service service = managerService.addService();
                            if (service != null) {
                                System.out.println("Thêm " + service.getName() + " thành công");
                            } else {
                                System.out.println("Thêm thất bại");
                            }
                            break;
                        case 6:
                            managerService.displayAllServices();
                            break;
                        case 7:
                            System.out.print("Nhập số tiền 1 giờ/máy: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            managerComputer.changePrice(price);
                            break;
                        case 8:
                            payment();
                            break;
                        case 9:
                            TurnoverByPeriod();
                            break;
                        case 10:
                            double totalTurnover = managerComputer.totalTurnover();
                            System.out.println("Tổng doanh thu: " + totalTurnover + " VND");
                            break;
                        case 0:
                            flag = false;
                            break;
                    }
                } while (choice != 0);

            } catch (Exception e) {
                System.err.println("\t\t\t\t\t\t\t_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_Không được đâu sói ạ_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            }
        }
    }

    private void TurnoverByPeriod() {
        System.out.print("Từ ngày (dd-LL-yyyy): ");
        String dateStart = scanner.nextLine();
        System.out.print("Đến ngày (dd-LL-yyyy): ");
        String dateEnd = scanner.nextLine();
        if (validateDate(dateStart) && validateDate(dateEnd)) {
            LocalDate start = managerComputer.convertStringToDate(dateStart);
            LocalDate end = managerComputer.convertStringToDate(dateEnd);
            double turnoverByDay = managerComputer.turnoverByDay(start, end);
            if (dateStart.compareTo(dateEnd) >= 0) {
                System.out.println("Ngày đầu lớn hơn ngày cuối...???");
            } else {
                System.out.println("Tổng doanh thu từ " + dateStart + " đến " + dateEnd + ": " + turnoverByDay + " VND");
            }
        } else {
            System.out.println("Nhập sai định dạng ngày rồi");
        }
    }

    private void payment() {
        int choice1;
        do {
            System.out.println("1. Thanh toán");
            System.out.println("2. Thêm dịch vụ");
            System.out.println("0. Quay lại");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice1 = Integer.parseInt(scanner.nextLine());

            if (choice1 == 1) {
                managerComputer.payment();
            } else if (choice1 == 2) {
                try {
                    managerService.displayAllServices();
                    System.out.print("Chọn dịch vụ muốn thêm: ");
                    int indexService = (Integer.parseInt(scanner.nextLine()) - 1);
                    double price = services.get(indexService).getPrice();
                    double quantity;
                    do {
                        System.out.print("Nhập số lượng muốn thêm: ");
                        quantity = Double.parseDouble(scanner.nextLine());
                    } while (quantity < 0);
                    double priceService = price * quantity;
                    managerComputer.addServiceToComputer(priceService);
                } catch (Exception e) {
                    System.out.println("Lỗi dữ liệu đầu vào");
                }
            }

        } while (choice1 != 0);
    }

    private void displayComputer() {
        int choice1;
        do {
            System.out.println("1. Hiển thị toàn bộ máy online");
            System.out.println("2. Hiển thị toàn bộ máy offline");
            System.out.println("0. Quay lại");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice1 = Integer.parseInt(scanner.nextLine());
            if (choice1 == 1) {
                managerComputer.displayDetails();
            } else if (choice1 == 2) {
                managerComputer.turnOnComputer();
            }
        } while (choice1 != 0);
    }

    private void deleteComputer() {
        int deleteNumber;
        System.out.print("Nhập vào số thứ tự của máy: ");
        deleteNumber = Integer.parseInt(scanner.nextLine());
        int choice1;
        System.out.println("1. Xác nhận xoá");
        System.out.println("0. Không xoá");
        System.out.print("Nhập vào lựa chọn của bạn: ");
        choice1 = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        if (choice1 == 1) {
            Computer computer = managerComputer.deleteComputer(deleteNumber);
            if (computer != null) {
                System.out.println("Xoá máy " + computer.getCode() + " thành công");
            } else {
                System.out.println("Xoá máy thất bại");
            }
        }
    }

    private void updateComputer() {
        int updateNumber;
        System.out.print("Nhập vào số thứ tự của máy: ");
        updateNumber = Integer.parseInt(scanner.nextLine());
        Computer computer = managerComputer.updateComputer(updateNumber);
        if (computer != null) {
            System.out.println("Sửa máy " + computer.getCode() + " thành công");
        } else {
            System.out.println("Sửa máy thất bại");
        }
    }

    private boolean validateDate(String date) {
        String DATE_REGEX = "^([0-9]|[0-2][0-9]|3[0-1])[-](0[0-9]|1[0-2]|[0-9])[-]([0-9][0-9])?[0-9][0-9]$";
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }
}
