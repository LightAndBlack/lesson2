package com.aston.javabase;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testAddWithDefaultConstructor() {
        Main.MyArrayList<String> list = new Main.MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    public void testAddWithInitialCapacity() {
        Main.MyArrayList<Integer> list = new Main.MyArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4); // Размер массива должен переопределиться
        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));

    }

    @Test
    public void testAddWithZeroCapacity() {
        Main.MyArrayList<Double> list = new Main.MyArrayList<>(0);
        list.add(3.14);
        list.add(3.14);
        list.add(2.71);
        assertEquals(3, list.size());
        assertEquals(Double.valueOf(3.14), list.get(0));
        assertEquals(Double.valueOf(3.14), list.get(1));
        assertEquals(Double.valueOf(2.71), list.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNegativeCapacity() {
        Main.MyArrayList<Integer> list = new Main.MyArrayList<>(-1);
    }

    @Test public void testAddByIndexWithinBounds() {
        Main.MyArrayList<String> list = new Main.MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
        list.add(1, "New Element");
        assertEquals(3, list.size());
        assertEquals("Hello", list.get(0));
        assertEquals("New Element", list.get(1));
        assertEquals("World", list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfBounds() {
        Main.MyArrayList<String> list = new Main.MyArrayList<>();
        list.add(2, "Test"); // Индекс 2 выходит за пределы массива
    }
}
