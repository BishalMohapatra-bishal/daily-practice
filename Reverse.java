import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word.");
        String reverse = sc.nextLine();
        StringBuilder result = new StringBuilder(); 

        for (int i = reverse.length() - 1; i >= 0; i--) {
            result.append(reverse.charAt(i));
        }
        System.out.println(result.toString());
    }
}
