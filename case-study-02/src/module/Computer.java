package module;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Computer extends Thread implements Serializable {
    private int code;
    private boolean status;
    private double timePrice;
    private double timeUsing;
    private double servicePrice;
    private LocalDate startTime;
    private LocalDate endTime;

    public Computer() {
    }

    public Computer(int code) {
        this.code = code;
        this.status = false;
        this.timePrice = 15000;
        this.timeUsing = 0;
        this.servicePrice = 0;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatus() {
        if (isStatus()) {
            return "Online";
        } else {
            return "Offline";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void changeStatus() {
        this.status = !status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(double price) {
        this.timePrice = price;
    }

    public double getTimeUsing() {
        return timeUsing;
    }

    public void setTimeUsing(double timeUsing) {
        this.timeUsing = timeUsing;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice += servicePrice;
    }

    public double totalPrice() {
        return ((getTimePrice() * getTimeUsing()) + getServicePrice());
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        this.startTime = LocalDate.now();
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        this.endTime = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Máy " +
                "số = " + getCode() +
                ", trạng thái = " + getStatus() +
                ", giá/giờ = " + getTimePrice() +
                ", giờ sử dụng = " + getTimeUsing() +
                ", tiền dịch vụ = " + getServicePrice() +
                ", tổng tiền = " + totalPrice();
    }

    @Override
    public void run() {
        while (status) {
            try {
                Thread.sleep(5000);
                this.timeUsing++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
