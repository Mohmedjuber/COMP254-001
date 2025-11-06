package exercise1;

public class Exercise1Demo {
    public static void main(String[] args) {
        PositionalList<String> list = new LinkedPositionalList<>();
        Position<String> pA = list.addLast("A");
        Position<String> pB = list.addLast("B");
        Position<String> pC = list.addLast("C");
        Position<String> pD = list.addLast("D");

        System.out.println("List elements:");
        for (String s : list) System.out.print(s + " ");
        System.out.println();

        System.out.println("indexOf(pA) = " + list.indexOf(pA)); // 0
        System.out.println("indexOf(pB) = " + list.indexOf(pB)); // 1
        System.out.println("indexOf(pC) = " + list.indexOf(pC)); // 2
        System.out.println("indexOf(pD) = " + list.indexOf(pD)); // 3

        // Move an element and confirm index updates
        list.remove(pB);
        Position<String> pB2 = list.addFirst("B"); // new position instance
        System.out.println("After moving 'B' to front:");
        for (String s : list) System.out.print(s + " ");
        System.out.println();
        System.out.println("indexOf(new pB) = " + list.indexOf(pB2)); // 0
    }
}