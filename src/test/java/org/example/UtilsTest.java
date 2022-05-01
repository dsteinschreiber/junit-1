package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.example.Utils.*;

public class UtilsTest {

    @Test
    public void sumTest() {
        assertEquals(0, sum(MyList.of()));
        assertEquals(0, recursiveSum(MyList.of()));

        assertEquals(6, sum(MyList.of(1, 2, 3)));
        assertEquals(6, recursiveSum(MyList.of(1, 2, 3)));
    }

    @Test
    public void productTest() {
        assertEquals(1, product(MyList.of()));
        assertEquals(1, recursiveProduct(MyList.of()));

        assertEquals(6, product(MyList.of(1, 2, 3)));
        assertEquals(6, recursiveProduct(MyList.of(1, 2, 3)));
    }

    @Test
    public void anyPositiveTest() {
        assertFalse(anyPositive(MyList.of()));
        assertFalse(recursiveAnyPositive(MyList.of()));

        assertTrue(anyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, 9)));

        assertFalse(anyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9)));

        assertTrue(recursiveAnyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, 9)));

        assertFalse(recursiveAnyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9)));
    }

    @Test
    public void anyNegativeTest() {
        assertFalse(anyNegative(MyList.of()));
        assertFalse(recursiveAnyNegative(MyList.of()));

        assertTrue(anyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, -9)));

        assertFalse(anyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));

        assertTrue(recursiveAnyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, -9)));

        assertFalse(recursiveAnyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void anyZeroTest() {
        assertFalse(anyZero(MyList.of()));
        assertFalse(recursiveAnyZero(MyList.of()));

        assertTrue(anyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        assertFalse(anyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        assertTrue(recursiveAnyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        assertFalse(recursiveAnyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void doubledTest() {
        assertEquals(MyList.of(), doubled(MyList.of()));
        assertEquals(MyList.of(), recursiveDoubled(MyList.of()));

        assertEquals(MyList.of(2, 4, 6, 8, 10), doubled(MyList.of(1, 2, 3, 4, 5)));
        assertEquals(MyList.of(2, 4, 6, 8, 10), recursiveDoubled(MyList.of(1, 2, 3, 4, 5)));
    }

//    @Test
//    public void doubledStrTest(){
//        assertEquals(MyList.of(), doubledStr(MyList.of()));
//
//        assertSame(MyList.of("hello hello", "world world"), doubledStr(MyList.of("hello", "world")));
//    }

    @Test
    public void lengthsTest() {
        assertEquals(MyList.of(), lengths(MyList.of()));

        assertEquals(MyList.of(1, 2, 3, 4), lengths(MyList.of("I", "am", "not", "dumb")));
    }

    @Test
    public void allPositiveTest() {
        assertTrue(allPositive(MyList.of()));
        assertTrue(recursiveAllPositive(MyList.of()));

        assertTrue(allPositive(MyList.of(1, 2, 3)));
        assertFalse(allPositive(MyList.of(1, 2, 3, -1)));

        assertTrue(recursiveAllPositive(MyList.of(1, 2, 3)));
        assertFalse(recursiveAllPositive(MyList.of(1, 2, 3, -1)));
    }

    @Test
    public void takeWhilePositiveTest() {
        assertEquals(MyList.of(), takeWhilePositive(MyList.of()));

        assertEquals(MyList.of(0, 1, 2, 3), takeWhilePositive(MyList.of(0, 1, 2, 3, -1, -2, 3)));
    }

    @Test
    public void filterPositiveTest() {
        assertEquals(MyList.of(), filterPositive(MyList.of()));

        assertEquals(MyList.of(0, 1, 2, 3), filterPositive(MyList.of(-3, -2, -1, 0, 1, 2, 3)));
    }

    @Test
    public void concatTest() {
        assertEquals("", concat(MyList.of()));

        assertEquals("HelloWorld", concat(MyList.of("Hello", "World")));
    }

    @Test
    public void concatLengthTest() {
        assertEquals(10,
                sum(lengths(MyList.of("Hello", "World"))));

        assertEquals(10,
                sum(MyList.of("Hello", "World").map(value -> value.length())));

        MyList<String> strList = MyList.of("Hello", "World");

        assertEquals(concat(strList).length(), sum(strList.map(value -> value.length())));
    }


    @Test
    public void listSumTest() {
        assertEquals(MyList.of(1, 2, 3), listSum(MyList.of(0, 1, 2), MyList.of(1, 1, 1)));
//        assertEquals(MyList.of(1, 2, 3, 3), listSum(MyList.of(1, 1, 1, 1), MyList.of(0, 1, 2)));
        assertEquals(MyList.of(5, 5, 5), listSum(MyList.of(1, 1, 1), MyList.of(2, 2, 2), MyList.of(2, 2, 2)));
        assertEquals(MyList.of(8, 8, 8),
                listSum(MyList.of(3, 3, 3), MyList.of(1, 1, 1), MyList.of(2, 2, 2), MyList.of(2, 2, 2)));

    }
}
