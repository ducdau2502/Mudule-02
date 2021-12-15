package baitap;

public class FizzBuzzTranslate {
    public static String isPuzzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
            return "FizzBuzz";

        } else if (isFizz) {
            return "Fizz";
        } else if (isBuzz) {
            return "Buzz";
        }
        int donVi = number - Math.round(number) / 10 * 10;
        int hangChuc = Math.round(number) / 10;
        return "" + readNumber(hangChuc) + " " + readNumber(donVi);
    }

    private static String readNumber(int number) {
        switch (number) {
            case 1:
                return "một";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bốn";
            case 5:
                return "năm";
            case 6:
                return "sau";
            case 7:
                return "bảy";
            case 8:
                return "tám";
            case 9:
                return "chín";
            default:
                return "out of range";
        }
    }
}
