package BaiTap.ClassFan;

public class Fan {

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public Fan() {
        this.speed = 1;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public String getSpeed() {
        if (this.speed == 1) {
            return "SLOW";
        } else if (this.speed == 2) {
            return "MEDIUM";
        } else {
            return "FAST";
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    "speed = " + getSpeed() +
                    ", radius = " + getRadius() +
                    ", color = '" + getColor() +
                    "', fan is on" + '\'' +
                    '}';
        }
        return "Fan{" +
                "radius = " + getRadius() +
                ", color = '" + getColor() +
                "', fan is off" + '\'' +
                '}';
    }
}
