package com.aston.javabase;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        testMyArrayList();
    }

    // Статичный метод для выполнения тестов
    private static void testMyArrayList() {
        // Пример 1: Инициализация с конструктором по умолчанию
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("Hello");
        list1.add("World");
        System.out.println("Список 1: " + Arrays.toString(list1.elements));
        System.out.println("Проверка метода get(int index): list1[0] == " + list1.get(0));
        System.out.println("Проверка метода get(int index): list1[1] == " + list1.get(1));

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

        System.out.println("\nПроверка метода добавления элемента по индексу: ");
        list1.add(1, "New Element");
        System.out.println("Список 1 после вставки по индексу 1: " + Arrays.toString(list1.elements));
        System.out.println("Проверка метода get(int index): list1[0] == " + list1.get(0));
        System.out.println("Проверка метода get(int index): list1[1] == " + list1.get(1));
        System.out.println("Проверка метода get(int index): list1[2] == " + list1.get(2));
    }
}