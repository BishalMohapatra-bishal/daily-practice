import java.util.Scanner;

public class ReverseAStringUsingInBuildMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String original = sc.nextLine();

         System.out.println("Word before reverse: " + original);

        StringBuilder builder = new StringBuilder(original);
        builder.reverse();

        System.out.println("Word after reverse: " + builder);

        sc.close();
    }
    
}
