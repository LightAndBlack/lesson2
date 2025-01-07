package com.aston.javabase;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс MyArrayList представляет собой динамический массив, который может хранить элементы любого типа.
 * Поддерживает операции добавления, удаления, получения элементов, а также сортировку.
 *
 * @param <T> Тип элементов, хранимых в списке.
 */
public class MyArrayList<T> {
    Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Создает новый MyArrayList с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Создает новый MyArrayList с указанной начальной емкостью.
     *
     * @param initialCapacity Начальная емкость списка.
     * @throws IllegalArgumentException если начальная емкость меньше нуля.
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elements = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Размер массива не может быть меньше 0");
        }
    }

    /**
     * Возвращает массив элементов списка.
     *
     * @return Массив элементов.
     */
    public Object[] getElements() {
        return elements;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления.
     */
    public void add(T element) {
        adjustCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Регулирует емкость массива для хранения элементов.
     *
     * @param minCapacity Минимальная требуемая емкость.
     */
    private void adjustCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(DEFAULT_CAPACITY, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Возвращает размер списка.
     *
     * @return Размер списка.
     */
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   Индекс для вставки элемента.
     * @param element Элемент для добавления.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    public void add(int index, T element) {
        checkIndexForAdd(index);
        adjustCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Проверяет корректность указанного индекса.
     *
     * @param index Индекс для проверки.
     * @param isAdd Если true, проверка для метода добавления.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    private void checkIndex(int index, boolean isAdd) {
        if (index < 0 || index >= size + (isAdd ? 1 : 0)) {
            throw new IndexOutOfBoundsException("Индекс: " + index + " выходит за пределы массива (Размер: " + size + ")");
        }
    }

    private void checkIndex(int index) {
        checkIndex(index, false);
    }

    private void checkIndexForAdd(int index) {
        checkIndex(index, true);
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента для удаления.
     * @return Удаленный элемент.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    public T remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        T deletedElement = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return deletedElement;
    }

    /**
     * Очищает список.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
    }

    /**
     * Сортирует список с использованием указанного компаратора.
     *
     * @param comparator Компаратор для сортировки элементов.
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Сортирует список с использованием естественного порядка элементов (Comparable).
     */
    public void sort() {
        quickSortComparable(0, size - 1);
    }

    private void quickSort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    private void quickSortComparable(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionComparable(low, high);
            quickSortComparable(low, pivotIndex - 1);
            quickSortComparable(pivotIndex + 1, high);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = (T) elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare((T) elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    @SuppressWarnings("unchecked")
    private int partitionComparable(int low, int high) {
        T pivot = (T) elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (((Comparable<? super T>) elements[j]).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
