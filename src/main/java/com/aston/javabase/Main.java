package com.aston.javabase;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

    }

    public class MyArrayList<T>{
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
                throw new IllegalArgumentException(initialCapacity + " < 0. Массив не может быть меньше 0");
            }
        }

        public void add(T element){
            adjustCapacity(size + 1);
            elements[size++] = element;
        }

        private void adjustCapacity(int minCapacity) {
            if (minCapacity > elements.length) {
                int newCapacity = Math.max(DEFAULT_CAPACITY, elements.length * 2);
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }
    }
}