package com.aston.javabase;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testMyArrayList();
    }

    // Статичный метод для выполнения тестов
    private static void testMyArrayList() {
        // Пример 1: Инициализация с конструктором по умолчанию
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("Hello");
        list1.add("World");
        System.out.println("Список 1: " + Arrays.toString(list1.elements));

        // Пример 2: Инициализация с заданной начальной емкостью
        MyArrayList<Integer> list2 = new MyArrayList<>(3);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4); // Должен вызвать adjustCapacity
        System.out.println("Список 2: " + Arrays.toString(list2.elements));

// Пример 3: Инициализация с нулевой емкостью
        MyArrayList<Double> list3 = new MyArrayList<>(0);
        list3.add(3.14);
        list3.add(3.14);
        list3.add(2.71);
        System.out.println("Список 3: " + Arrays.toString(list3.elements));
    }

    public static class MyArrayList<T>{
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;

//        Конструктор без параметров
        public MyArrayList(){
            elements = new Object[DEFAULT_CAPACITY];
        }

//        Конструктор с заданной начальной емкостью
        public MyArrayList(int initialCapacity){
            if (initialCapacity >= 0) {
                elements = new Object[initialCapacity];
            }
            else {
                throw new IllegalArgumentException(initialCapacity + " < 0. Размер массива не может быть меньше 0");
            }
        }

        public void add(T element){
            adjustCapacity(size + 1); // Проверить, свободно ли следующее место во внешнем массиве
            elements[size++] = element;         // В массив с ном индекса ТЕК р-ра ДОБ НОВ эл-т, р-р массива ув-ть на 1
        }

        private void adjustCapacity(int minCapacity) {
            if (minCapacity > elements.length) {
                int newCapacity = Math.max(DEFAULT_CAPACITY, elements.length * 2);
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }

        // Метод получения размера текущего списка из любого места программы
        public int size(){
            return size;
        }
    }
}