import java.util.Scanner;

public class ReverseInteger {
    public static int reverseNumber(int n) {
        int reversed = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            reversed = (reversed * 10) + lastDigit;

            n = n / 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int num = sc.nextInt();

        int result = reverseNumber(num);
        System.out.println("Reversed Number: " + result);

        sc.close();
    }
}