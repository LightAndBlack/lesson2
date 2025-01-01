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
    }

    @Test
    public void testAddWithInitialCapacity() {
        Main.MyArrayList<Integer> list = new Main.MyArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4); // Размер массива должен переопределиться
        assertEquals(4, list.size());
    }

    @Test
    public void testAddWithZeroCapacity() {
        Main.MyArrayList<Double> list = new Main.MyArrayList<>(0);
        list.add(3.14);
        list.add(3.14);
        list.add(2.71);
        assertEquals(3, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNegativeCapacity() {
        Main.MyArrayList<Integer> list = new Main.MyArrayList<>(-1);
    }
}
