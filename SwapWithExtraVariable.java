public class SwapWithExtraVariable {
    public static void main(String[] args) {
        int a = 7;
        int b = 8;

        System.out.println("Before: " + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b);

        int c = a;
        a = b;
        b = c;

        System.out.println("After: " + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b);
    }
}