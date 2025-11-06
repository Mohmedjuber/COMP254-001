package exercise2;

public class Exercise2Demo {
    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>();
        ArrayStack<Integer> T = new ArrayStack<>();

        for (int i = 1; i <= 5; i++) S.push(i); // top is 5
        System.out.println("Initial S: " + S);
        System.out.println("Initial T: " + T);

        Stacks.transfer(S, T);

        System.out.println("After transfer(S, T):");
        System.out.println("S (should be empty): " + S);
        System.out.println("T (top should be 1st inserted = 5? check): " + T);
        // Verify top of T is bottom of original S (1 should be at the bottom of T)
        System.out.println("Top of T: " + T.top());
    }
}