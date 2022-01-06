package module;

import java.io.Serializable;

public class Computer implements Serializable {
    private int code;
    private boolean status;
    private double timePrice;
    private double servicePrice;
    private double startTime;
    private double endTime;

    public Computer() {
    }

    public Computer(int code) {
        this.code = code;
        this.status = false;
        this.timePrice = 15000;
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
        if (isStatus()) {
            setEndTime(System.currentTimeMillis());
            return (getEndTime() - getStartTime())/20000;
        } else {
            return 0;
        }
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

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double time) {
        this.startTime = time;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double time) {
        this.endTime = time;
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

}
