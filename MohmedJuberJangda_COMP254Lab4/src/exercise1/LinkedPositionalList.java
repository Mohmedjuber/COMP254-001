package exercise1;

/**
 * A minimal doubly-linked implementation of PositionalList for testing.
 * This class intentionally exposes no internal nodes outside of Position,
 * so the default indexOf implementation truly uses only ADT methods.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

    // ----- Node -----
    private static class Node<E> implements Position<E> {
        E element;
        Node<E> prev, next;
        Node(E e, Node<E> p, Node<E> n) { element = e; prev = p; next = n; }
        public E getElement() { return element; }
    }

    private Node<E> header, trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    private Position<E> position(Node<E> node) {
        return (node == header || node == trailer) ? null : node;
    }

    private Node<E> validate(Position<E> p) {
        if (p == null) throw new IllegalArgumentException("Null position");
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;
        if (node.next == null) throw new IllegalArgumentException("Position no longer in list");
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.next = newest;
        succ.prev = newest;
        size++;
        return newest;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Position<E> first() { return position(header.next); }
    public Position<E> last() { return position(trailer.prev); }

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.prev);
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.next);
    }

    public Position<E> addFirst(E e) { return addBetween(e, header, header.next); }
    public Position<E> addLast(E e) { return addBetween(e, trailer.prev, trailer); }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.prev, node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.next);
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.element;
        node.element = e;
        return old;
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        E answer = node.element;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null; node.prev = null; node.element = null;
        size--;
        return answer;
    }
}