package baitap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {
    @Test
    @DisplayName("Tam giác đều")
    void test01() {
        double number1 = 2;
        double number2 = 2;
        double number3 = 2;
        String expected = "Tam giác đều";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Tam giác cân")
    void test02() {
        double number1 = 2;
        double number2 = 2;
        double number3 = 3;
        String expected = "Tam giác cân";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Tam giác vuông")
    void test03() {
        double number1 = 3;
        double number2 = 4;
        double number3 = 5;
        String expected = "Tam giác vuông";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Tam giác thường")
    void test04() {
        double number1 = 6;
        double number2 = 5;
        double number3 = 7;
        String expected = "Đây là tam giác thường";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("false01")
    void test05() {
        double number1 = -1;
        double number2 = 2;
        double number3 = 1;
        String expected = "Đây không phải tam giác";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("false02")
    void test06() {
        double number1 = 0;
        double number2 = 1;
        double number3 = 1;
        String expected = "Đây không phải tam giác";
        String result = TriangleClassifier.classifierTriangle(number1, number2, number3);
        assertEquals(expected, result);
    }

}