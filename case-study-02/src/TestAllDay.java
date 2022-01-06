import java.util.Date;

public class TestAllDay {
    public static void main(String[] args) {
        double a = System.currentTimeMillis();
        Date date = new Date((long) a);
        Date date1 = new Date(2021, 0, 8);

//        System.out.println(ah);
        System.out.println(date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear() + 1900));
        System.out.println(date1.getDate() + "/" + (date1.getMonth()) + "/" + (date1.getYear()));
    }
}
