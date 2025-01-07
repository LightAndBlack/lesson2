package com.aston.javabase;

import java.util.Random;

public class Car implements Comparable<Car> {
    private final String name;
    private final int year;
    private final int maxSpeed;

    public Car(String name, int year, int maxSpeed) {
        this.name = name;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year);
    }

    public static MyArrayList<Car> generateCars(int numberOfCars) {
        MyArrayList<Car> cars = new MyArrayList<>(numberOfCars);
        Random random = new Random();

        for (int i = 1; i <= numberOfCars; i++) {
            String name = "auto" + i;
            int year = 1990 + random.nextInt(2024 - 1990 + 1);
            int maxSpeed = 180 + random.nextInt(181); // 180 включительно и до 360 включительно
            cars.add(new Car(name, year, maxSpeed));
        }

        return cars;
    }
}
