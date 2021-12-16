package baitap.arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = size ; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        Object e = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return (E) e;
    }

    public int size() {
        return size;
    }

    public E[] clone() {
        Object e = (E) Arrays.copyOf(elements, size);
        return (E[]) e;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = e;
        size++;
        return true;
    }


    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


}
