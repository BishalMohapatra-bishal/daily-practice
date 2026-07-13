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

        sc.close();

        // Second way
        String getReverse = reverceInPlace("Barasa");
        System.out.println(getReverse);
    }
    public static String reverceInPlace(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length -1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }
}
