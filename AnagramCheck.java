import java.util.Scanner;

public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i) - 'a']++;
            
            charCounts[s2.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first word:");
        String first = sc.nextLine();
        
        System.out.println("Enter second word:");
        String second = sc.nextLine();

        if (isAnagram(first, second)) {
            System.out.println("The words are Anagrams.");
        } else {
            System.out.println("The words are NOT Anagrams.");
        }

        sc.close();
    }
}