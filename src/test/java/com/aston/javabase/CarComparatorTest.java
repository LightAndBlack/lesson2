package com.aston.javabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class CarComparatorTest {
    private MyArrayList<Car> carList;
    private final Random random = new Random();

    @BeforeEach
    public void setUp() {
        carList = new MyArrayList<>(200);
        for (int i = 1; i <= 200; i++) {
            String name = "auto" + i;
            int year = 1990 + random.nextInt(2024 - 1990 + 1);
            int maxSpeed = 180 + random.nextInt(181); // 180 включительно и до 360 включительно
            carList.add(new Car(name, year, maxSpeed));
        }
    }

    @Test
    public void testComparatorSortByMaxSpeed() {
        carList.sort(Comparator.comparingInt(Car::getMaxSpeed));
        for (int i = 0; i < carList.size() - 1; i++) {
            assertTrue(carList.get(i).getMaxSpeed() <= carList.get(i + 1).getMaxSpeed());
        }
    }

    @Test
    public void testComparableSortByYear() {
        carList.sort();
        for (int i = 0; i < carList.size() - 1; i++) {
            assertTrue(carList.get(i).getYear() <= carList.get(i + 1).getYear());
        }
    }
}
