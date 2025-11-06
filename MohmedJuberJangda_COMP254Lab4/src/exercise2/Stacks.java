package exercise2;

/** Utility algorithms for stacks. */
public final class Stacks {
    private Stacks() {}

    /**
     * Transfers all elements from S onto T.
     * After the call: S is empty; T has elements with S's bottom at T's top.
     * Runs in O(n).
     */
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }
}