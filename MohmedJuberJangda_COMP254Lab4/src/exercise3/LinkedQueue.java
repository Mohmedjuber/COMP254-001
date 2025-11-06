package exercise3;

import java.util.NoSuchElementException;

/** A singly linked FIFO queue with O(1) concatenate. */
public class LinkedQueue<E> {

    private static class Node<E> {
        E e;
        Node<E> next;
        Node(E e, Node<E> n) { this.e = e; this.next = n; }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = tail = newest;
        } else {
            tail.next = newest;
            tail = newest;
        }
        size++;
    }

    public E first() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return head.e;
    }

    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        E answer = head.e;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return answer;
    }

    /**
     * Append all elements of Q2 to the end of this queue in O(1) time.
     * After the operation, Q2 becomes empty.
     */
    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2 == null || Q2.isEmpty()) return;
        if (this.isEmpty()) {
            this.head = Q2.head;
            this.tail = Q2.tail;
            this.size = Q2.size;
        } else {
            this.tail.next = Q2.head;
            this.tail = Q2.tail;
            this.size += Q2.size;
        }
        // Empty Q2
        Q2.head = Q2.tail = null;
        Q2.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.e);
            if (walk.next != null) sb.append(", ");
            walk = walk.next;
        }
        sb.append("] (front on left)");
        return sb.toString();
    }
}