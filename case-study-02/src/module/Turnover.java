package module;

public class Turnover {
    private int day;
    private int month;
    private int year;
    private double turnover;

    public Turnover() {
    }

    public Turnover(int day, int month, int year, double turnover) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.turnover = turnover;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return day +
                "/" + month +
                "/" + year +
                ", doanh thu = " + turnover;
    }
}
