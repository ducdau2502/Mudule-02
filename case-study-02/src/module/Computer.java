package module;

import java.io.Serializable;

public class Computer implements Serializable {
    private int code;
    private boolean status;
    private double price;

    public Computer() {
    }

    public Computer(int code) {
        this.code = code;
        this.status = false;
        this.price = 20000;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatus(){
        if (isStatus()) {
            return "Offline";
        }else {
            return "Online";
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



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Máy " +
                "số = " + code +
                ", trang thái = " + getStatus();
    }
}
