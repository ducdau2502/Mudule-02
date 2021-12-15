package baitap;

public class TriangleClassifier {
    public static String classifierTriangle(double number1, double number2, double number3) {
        if (number1 > 0 && number2 > 0 && number3 > 0) {
            if (number1 + number2 > number3 &&
                    number1 + number3 > number2 &&
                    number3 + number2 > number1) {
                if (number1 == number2 && number2 == number3 && number3 == number1) {
                    return  "Tam giác đều";
                } else if (number1 == number2 || number2 == number3 || number3 == number1) {
                    return  "Tam giác cân";
                } else if ((Math.pow(number1, 2) == Math.pow(number2, 2) + Math.pow(number3, 2)) ||
                (Math.pow(number2, 2) == Math.pow(number1, 2) + Math.pow(number3, 2)) ||
                (Math.pow(number3, 2) == Math.pow(number1, 2) + Math.pow(number2, 2))) {
                    return "Tam giác vuông";
                } else {
                    return "Đây là tam giác thường";
                }
            } else {
                return  "Đây không phải tam giác";
            }
        } else {
            return  "Đây không phải tam giác";
        }
    }
}
