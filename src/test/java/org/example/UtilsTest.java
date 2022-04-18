package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    public void sumTest() {
        assertEquals(0, Utils.sum(MyList.of()));
        assertEquals(0, Utils.recursiveSum(MyList.of()));

        assertEquals(6, Utils.sum(MyList.of(1, 2, 3)));
        assertEquals(6, Utils.recursiveSum(MyList.of(1, 2, 3)));
    }

    @Test
    public void productTest() {
        assertEquals(1, Utils.product(MyList.of()));
        assertEquals(1, Utils.recursiveProduct(MyList.of()));

        assertEquals(6, Utils.product(MyList.of(1, 2, 3)));
        assertEquals(6, Utils.recursiveProduct(MyList.of(1, 2, 3)));
    }

    @Test
    public void anyPositiveTest() {
        assertFalse(Utils.anyPositive(MyList.of()));
        assertFalse(Utils.recursiveAnyPositive(MyList.of()));

        assertTrue(Utils.anyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, 9)));

        assertFalse(Utils.anyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9)));

        assertTrue(Utils.recursiveAnyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, 9)));

        assertFalse(Utils.recursiveAnyPositive(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9)));
    }

    @Test
    public void anyNegativeTest() {
        assertFalse(Utils.anyNegative(MyList.of()));
        assertFalse(Utils.recursiveAnyNegative(MyList.of()));

        assertTrue(Utils.anyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, -9)));

        assertFalse(Utils.anyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));

        assertTrue(Utils.recursiveAnyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, -9)));

        assertFalse(Utils.recursiveAnyNegative(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void anyZeroTest() {
        assertFalse(Utils.anyZero(MyList.of()));
        assertFalse(Utils.recursiveAnyZero(MyList.of()));

        assertTrue(Utils.anyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        assertFalse(Utils.anyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        assertTrue(Utils.recursiveAnyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        assertFalse(Utils.recursiveAnyZero(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void doubledTest() {
        assertEquals(MyList.of(), Utils.doubled(MyList.of()));
        assertEquals(MyList.of(), Utils.recursiveDoubled(MyList.of()));

        assertEquals(MyList.of(2, 4, 6, 8, 10), Utils.doubled(MyList.of(1, 2, 3, 4, 5)));
        assertEquals(MyList.of(2, 4, 6, 8, 10), Utils.recursiveDoubled(MyList.of(1, 2, 3, 4, 5)));
    }

//    @Test
//    public void doubledStrTest(){
//        assertEquals(MyList.of(), Utils.doubledStr(MyList.of()));
//
//        assertSame(MyList.of("hello hello", "world world"), Utils.doubledStr(MyList.of("hello", "world")));
//    }

    @Test
    public void lengthsTest() {
        assertEquals(MyList.of(), Utils.lengths(MyList.of()));

        assertEquals(MyList.of(1, 2, 3, 4), Utils.lengths(MyList.of("I", "am", "not", "dumb")));
    }

    @Test
    public void allPositiveTest() {
        assertTrue(Utils.allPositive(MyList.of()));
        assertTrue(Utils.recursiveAllPositive(MyList.of()));

        assertTrue(Utils.allPositive(MyList.of(1, 2, 3)));
        assertFalse(Utils.allPositive(MyList.of(1, 2, 3, -1)));

        assertTrue(Utils.recursiveAllPositive(MyList.of(1, 2, 3)));
        assertFalse(Utils.recursiveAllPositive(MyList.of(1, 2, 3, -1)));
    }

    @Test
    public void takeWhilePositive() {
        assertEquals(MyList.of(), Utils.takeWhilePositive(MyList.of()));

        assertEquals(MyList.of(0, 1, 2, 3), Utils.takeWhilePositive(MyList.of(0, 1, 2, 3, -1, -2, 3)));
    }

    @Test
    public void filterPositiveTest() {
        assertEquals(MyList.of(), Utils.filterPositive(MyList.of()));

        assertEquals(MyList.of(0, 1, 2, 3), Utils.filterPositive(MyList.of(-3, -2, -1, 0, 1, 2, 3)));
    }
}
