package com.aston.javabase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setUp() {
        myArrayList = new MyArrayList<>(200);
        for (int i = 0; i < 200; i++) {
            myArrayList.add(i);
        }
    }

    @Test
    public void testAddWithDefaultConstructor() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    public void testAddWithInitialCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
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
        MyArrayList<Double> list = new MyArrayList<>(0);
        list.add(3.14);
        list.add(3.14);
        list.add(2.71);
        assertEquals(3, list.size());
        assertEquals(Double.valueOf(3.14), list.get(0));
        assertEquals(Double.valueOf(3.14), list.get(1));
        assertEquals(Double.valueOf(2.71), list.get(2));
    }

    @Test
    public void testAddWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MyArrayList<>(-1);
        });
    }

    @Test
    public void testAddByIndexWithinBounds() {
        MyArrayList<String> list = new MyArrayList<>();
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

    @Test
    public void testAddByIndexOutOfBounds() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, "Test"); // Индекс 2 выходит за пределы массива
        });
    }

    @Test
    public void testRemoveByIndex() {
        int removedElement = myArrayList.remove(100);
        assertEquals(100, removedElement);
        assertEquals(199, myArrayList.size());

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), myArrayList.get(i));
        }

        for (int i = 100; i < 199; i++) {
            assertEquals(Integer.valueOf(i + 1), myArrayList.get(i));
        }
    }

    @Test
    public void testRemoveByIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myArrayList.remove(200); // Индекс выходит за пределы массива
        });
    }

    @Test
    public void testClear() {
        myArrayList.clear();

        for (int i = 0; i < myArrayList.size(); i++) {
            assertNull(myArrayList.get(i), "Element at index " + i + " should be null");
        }
    }
}
