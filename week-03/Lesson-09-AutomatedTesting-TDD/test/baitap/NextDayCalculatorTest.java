package baitap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class NextDayCalculatorTest {

    @Test
    @DisplayName("1-1-2018")
    public void nextDay0() {
        int day = 1;
        int month = 1;
        int year = 2018;
        String expect = "2-1-2018";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("31-1-2018")
    public void nextDay1() {
        int day = 31;
        int month = 1;
        int year = 2018;
        String expect = "1-2-2018";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("30-4-2018")
    public void nextDay2() {
        int day = 30;
        int month = 4;
        int year = 2018;
        String expect = "1-5-2018";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("28-2-2018")
    public void nextDay3() {
        int day = 28;
        int month = 2;
        int year = 2018;
        String expect = "1-3-2018";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("29-2-2020")
    public void nextDay4() {
        int day = 29;
        int month = 2;
        int year = 2020;
        String expect = "1-3-2020";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("31-12-2018")
    public void nextDay5() {
        int day = 31;
        int month = 12;
        int year = 2018;
        String expect = "1-1-2019";
        String result = NextDayCalculator.NextDay(day, month, year);
        assertEquals(expect, result);
    }

}