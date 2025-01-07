package com.aston.javabase;

import java.util.Random;

/**
 * Класс Car представляет объект автомобиля с полями name, year и maxSpeed.
 * Класс реализует интерфейс Comparable для сравнения объектов по году выпуска.
 */
public class Car implements Comparable<Car> {
    private final String name;
    private final int year;
    private final int maxSpeed;

    /**
     * Создает новый объект Car с указанными параметрами.
     *
     * @param name      Название автомобиля.
     * @param year      Год выпуска автомобиля.
     * @param maxSpeed  Максимальная скорость автомобиля.
     */
    public Car(String name, int year, int maxSpeed) {
        this.name = name;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Возвращает название автомобиля.
     *
     * @return Название автомобиля.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает год выпуска автомобиля.
     *
     * @return Год выпуска автомобиля.
     */
    public int getYear() {
        return year;
    }

    /**
     * Возвращает максимальную скорость автомобиля.
     *
     * @return Максимальная скорость автомобиля.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Сравнивает текущий объект Car с указанным объектом Car по году выпуска.
     *
     * @param other Другой объект Car для сравнения.
     * @return Отрицательное число, если текущий объект Car выпущен раньше,
     *         ноль, если они выпущены в один год, и положительное число,
     *         если текущий объект Car выпущен позже.
     */
    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year);
    }

    /**
     * Генерирует список автомобилей с указанным количеством.
     *
     * @param numberOfCars Количество автомобилей для генерации.
     * @return Список автомобилей.
     */
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
