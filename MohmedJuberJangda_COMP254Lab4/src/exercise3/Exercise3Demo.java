package exercise3;

public class Exercise3Demo {
    public static void main(String[] args) {
        LinkedQueue<String> q1 = new LinkedQueue<>();
        LinkedQueue<String> q2 = new LinkedQueue<>();

        q1.enqueue("A"); q1.enqueue("B");
        q2.enqueue("C"); q2.enqueue("D"); q2.enqueue("E");

        System.out.println("Before concatenate:");
        System.out.println("Q1: " + q1);
        System.out.println("Q2: " + q2);

        q1.concatenate(q2);

        System.out.println("\nAfter q1.concatenate(q2):");
        System.out.println("Q1: " + q1 + "  (size=" + q1.size() + ")");
        System.out.println("Q2: " + q2 + "  (should be empty, size=" + q2.size() + ")");
        System.out.println("First of Q1 (should be A): " + q1.first());
    }
}