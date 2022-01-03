package module;

public class Computer {
    private int code;
    private boolean status;
    private double price;

    public Computer() {
    }

    public Computer(int code) {
        this.code = code;
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
                ", trang thái = " + status;
    }
}
