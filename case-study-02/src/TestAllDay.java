import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestAllDay {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2021, 1, 10);
        LocalTime startTime = LocalTime.of(13, 30);
        LocalDateTime start = LocalDateTime.of(startDate, startTime);
        LocalDate endDate = LocalDate.of(2021, 1, 11);
        LocalTime endTime = LocalTime.of(13, 30);
        LocalDateTime end = LocalDateTime.of(endDate, endTime);

        double sum = (((end.getYear() - start.getYear()) * 8766) +
                ((end.getMonthValue() - start.getMonthValue()) * 730.5) +
                ((end.getDayOfMonth() - start.getDayOfMonth()) * 24) +
                (end.getHour() - start.getHour()) +
                ((end.getMinute() - start.getMinute()) / 60)) * 15000;

        System.out.println(sum);
    }
}
