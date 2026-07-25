public class SwapWithOutExtraVariable {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        
        System.out.println("Before:" + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b);

        a = a + b; // a = 1 + 2 = 3;
        b = a - b; // b = 3 - 2 = 1;
        a = a - b; // a = 3 - 1 = 2;

        System.out.println("After:" + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b);

        System.out.println("-------------------------------------------------------------------------------------------");

        int c = 2;
        int d = 1;

        System.out.println("Before" + "\n" + "Value of c: " + c + "\n" + "Value of d: " + d);
        
        c = c + d;
        d = c - d;
        c = c - d;

        System.out.println("After" + "\n" + "Value of c: " + c + "\n" + "Value of d: " + d);

    }
    
}
