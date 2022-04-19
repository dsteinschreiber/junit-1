package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.example.Utils.*;


public class MyListTest {

    @Test
    public void basicTest() {
        assertNull(MyList.of().head);

    }

    @Test
    public void isEmptyTest() {
        assertTrue(MyList.of().isEmpty());
        assertFalse(MyList.of(1, 2, 3).isEmpty());
    }

    @Test
    public void rangeTest() {
        assertEquals(MyList.range(1, 1), MyList.of(1));

        assertTrue(MyList.range(1, 0).isEmpty());

        assertEquals(MyList.range(1, 2), MyList.of(1, 2));

        assertEquals(MyList.range(1, 2, -1), MyList.of(1, 0));
    }

    @Test
    public void removeTest() {
        // How?
    }


    @Test
    public void getTest() {
        assertNull(MyList.of().get(0));
        assertNull(MyList.of().get(1));
        assertNull(MyList.of().get(-1));

        assertEquals(1, MyList.of(1, 2, 3).get(0).value);
        assertEquals(2, MyList.of(1, 2, 3).get(1).value);
        assertEquals(3, MyList.of(1, 2, 3).get(2).value);
        assertNull(MyList.of(1, 2, 3).get(3));
    }

    @Test
    public void sizeTest() {
        assertEquals(0, MyList.of().size());

        assertEquals(10, MyList.range(1, 10).size());

    }


    @Test
    public void reverseTest() {

        assertTrue(MyList.range(1, 10).reverse().equals(MyList.range(10, 10, -1)));

        assertEquals(MyList.range(10, 10, -1), MyList.range(1, 10).reverse());

        assertTrue(MyList.of(1, 2).reverse().equals(MyList.of(2, 1)));

        assertEquals(MyList.of(1, 2).reverse(), MyList.of(2, 1));
    }

    @Test
    public void containsTest() {
        assertFalse(MyList.of().contains(0));
        assertFalse(MyList.of().recursiveContains(0));

        assertTrue(MyList.of(1, 2, 3).contains(1));
        assertTrue(MyList.of(1, 2, 3).contains(2));
        assertTrue(MyList.of(1, 2, 3).contains(3));
        assertFalse(MyList.of(1, 2, 3).contains(4));
        assertFalse(MyList.of(1, 2, 3).contains(5));
        assertFalse(MyList.of(1, 2, 3).contains(6));

        assertTrue(MyList.of(1, 2, 3).recursiveContains(1));
        assertTrue(MyList.of(1, 2, 3).recursiveContains(2));
        assertTrue(MyList.of(1, 2, 3).recursiveContains(3));
        assertFalse(MyList.of(1, 2, 3).recursiveContains(4));
        assertFalse(MyList.of(1, 2, 3).recursiveContains(5));
        assertFalse(MyList.of(1, 2, 3).recursiveContains(6));
    }

    @Test
    public void anyTest() {
        assertTrue(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, 10).any(value -> value > 0));
        assertFalse(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10).any(value -> value > 0));
        assertTrue(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, -10).any(value -> value < 0));
        assertFalse(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).any(value -> value < 0));
        assertTrue(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).any(value -> value == 0));
        assertFalse(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).any(value -> value == 0));

        assertTrue(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, 10).recursiveAny(value -> value > 0));
        assertFalse(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10).recursiveAny(value -> value > 0));
        assertTrue(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, -10).recursiveAny(value -> value < 0));
        assertFalse(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).recursiveAny(value -> value < 0));
        assertTrue(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).recursiveAny(value -> value == 0));
        assertFalse(MyList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).recursiveAny(value -> value == 0));
    }

    @Test
    public void allTest() {
        // Need to figure out how to test empty list
        MyList<Integer> intList = new MyList<>();

        assertTrue(intList.all(value -> value > 0));

        assertTrue(MyList.range(2, 10, 2).all(value -> value % 2 == 0));
        assertTrue(MyList.range(1, 10, 2).all(value -> value % 2 != 0));
        assertFalse(MyList.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10).all(value -> value > 0));
        assertFalse(MyList.range(1, 10).all(value -> value < 0));
    }

    @Test
    public void mapTest() {
        MyList<Integer> intList = new MyList<>();

        assertEquals(MyList.of(), intList.map(value -> value + 1));
        assertEquals(MyList.of(), intList.recursiveMap(value -> value + 1));

        assertEquals(MyList.of(1, 2, 3), MyList.of(0, 1, 2).map(value -> value + 1));
        assertEquals(MyList.of(1, 2, 3), MyList.of(0, 1, 2).recursiveMap(value -> value + 1));

        MyList<String> strList = new MyList<>();

        assertEquals(MyList.of(), strList.map(value -> value + value));
        assertEquals(MyList.of(), strList.recursiveMap(value -> value + value));

//        assertEquals(MyList.of("HelloHello", "WorldWorld"), MyList.of("Hello", "World").map(value -> value + value));
//        assertEquals(MyList.of("HelloHello", "WorldWorld"), MyList.of("Hello", "World").recursiveMap(value -> value + value));


    }

    @Test
    public void takeTest() {
        assertEquals(MyList.of(), MyList.of().take(3));

        assertEquals(MyList.of(1, 2, 3), MyList.of(1, 2, 3, 4, 5).take(3));
    }

    @Test
    public void takeWhileTest() {
        MyList<Integer> intList = new MyList<>();

        assertEquals(MyList.of(), intList.takeWhile(value -> value > 0));

        assertEquals(MyList.of(1, 2, 3), MyList.of(1, 2, 3, -1).takeWhile(value -> value > 0));
    }

    @Test
    public void filterTest() {
        MyList<Integer> intList = new MyList<>();

        assertEquals(MyList.of(), intList.filter(value -> value > 0));

        assertEquals(MyList.of(1, 2, 3), MyList.of(-1, -2, -3, 0, 1, 2, 3).filter(value -> value > 0));
    }

    @Test
    public void reduceTest() {
        assertEquals(6, MyList.of(1, 2, 3)
                .reduce(0, (result, value) -> result + value));

        assertEquals(10, MyList.of(1, 2, 5)
                .reduce(1, (result, value) -> result * value));

        assertEquals(concat(MyList.of("Hello", "World")),
                MyList.of("Hello","World").reduce("",(result,value) -> result + value));

    }
}
