import java.util.Scanner;

public class PalindromeNumberCheck {


    public static boolean checkPalindrome(int no) {
        int reversed = 0;
        int newNo = no;
        while(no != 0) {
            int lastDigit = no % 10;

            reversed = (reversed * 10) + lastDigit;

            no = no / 10;

        }

        return newNo == reversed;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int no = sc.nextInt();

       boolean result = checkPalindrome(no);

       if(result) {
        System.out.println("This is a palindrome.");
       } else {
        System.out.println("This is not a palindrome.");
       }

       sc.close();
    }
    
}
