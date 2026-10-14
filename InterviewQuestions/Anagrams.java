package InterviewQuestions;

import java.util.Scanner;

public class Anagrams {
    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        s1.toLowerCase();
        s2.toLowerCase();

        int[] counts = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string.");
        String s1 = sc.nextLine();

        System.out.println("Enter second string.");
        String s2 = sc.nextLine();

        if (checkAnagram(s1, s2)) {
            System.out.println("It is a Anagrams");
        } else {
            System.out.println("It is not a Anagrams");
        }
    }
}
