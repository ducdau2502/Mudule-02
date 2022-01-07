package module;

import java.time.LocalDate;

public class Turnover {
    private LocalDate day;
    private double turnover;

    public Turnover() {
    }

    public Turnover(LocalDate day, double turnover) {
        this.day = day;
        this.turnover = turnover;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "Turnover{" +
                "day=" + day +
                ", turnover=" + turnover +
                '}';
    }
}
