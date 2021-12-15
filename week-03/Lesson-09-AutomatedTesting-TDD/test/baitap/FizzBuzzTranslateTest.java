package baitap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {
    @Test
    @DisplayName("Fizz")
    void test01() {
        int number = 3;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.isPuzzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Buzz")
    void test02() {
        int number = 5;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.isPuzzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("FizzBuzz")
    void test03() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.isPuzzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("False")
    void test04() {
        int number = 19;
        String expected = "một chín";
        String result = FizzBuzzTranslate.isPuzzBuzz(number);
        assertEquals(expected, result);
    }

}