package exercise1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PositionalList ADT with a default method indexOf(p) implemented
 * using only ADT operations (no reliance on concrete implementation details).
 */
public interface PositionalList<E> extends Iterable<E> {

    int size();
    boolean isEmpty();

    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> p);
    Position<E> after(Position<E> p);

    Position<E> addFirst(E e);
    Position<E> addLast(E e);
    Position<E> addBefore(Position<E> p, E e);
    Position<E> addAfter(Position<E> p, E e);

    E set(Position<E> p, E e);
    E remove(Position<E> p);

    /**
     * Default ADT-level operation: return the zero-based index of position p.
     * Runs in O(n) by walking forward from first() until p is encountered.
     */
    default int indexOf(Position<E> p) {
        if (p == null) throw new IllegalArgumentException("Position cannot be null");
        int i = 0;
        for (Position<E> walk = first(); walk != null; walk = after(walk)) {
            if (walk == p) return i;
            i++;
        }
        throw new NoSuchElementException("Position does not belong to this list");
    }

    /** Returns an iterator over elements (convenience). */
    default Iterator<E> iterator() {
        return new Iterator<E>() {
            private Position<E> walk = first();
            public boolean hasNext() { return walk != null; }
            public E next() {
                if (walk == null) throw new NoSuchElementException();
                E e = walk.getElement();
                walk = after(walk);
                return e;
            }
        };
    }
}