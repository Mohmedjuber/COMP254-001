package exercise2;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int size;

    public ArrayStack() { this(16); }
    public ArrayStack(int capacity) {
        data = new Object[Math.max(1, capacity)];
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(E e) {
        if (size == data.length) data = Arrays.copyOf(data, data.length * 2);
        data[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E top() {
        if (isEmpty()) throw new EmptyStackException();
        return (E) data[size - 1];
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E e = (E) data[--size];
        data[size] = null;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append("] (top on left)");
        return sb.toString();
    }
}