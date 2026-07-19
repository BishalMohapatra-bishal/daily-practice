package StreamAPIDailyPractice;

import java.util.List;

public class PalindromeCheckUsingStream {
    public static void main(String[] args) {
        
        List<String> words = List.of("Mom", "Dad", "Eye","Pop", "Bishal", "Barasa", "Gudu", "Did", "Shree");

        // for(String p : words) {
        //    List<String> pw =  words.stream().filter(w -> w.toLowerCase().equals(p)).toList();
           
        //    System.out.println(pw);
        // }

        // boolean hasPalindrome = words.stream().anyMatch(s -> isPalindrome(s));
        // System.out.println(hasPalindrome);

        // boolean hasaPalindrome = words.stream().anyMatch(s -> s != null && s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())); in a single line all check done no need of extra method.
        //  //it will return false if it have a palindrome word.

        List<String> palindroList = words.stream().filter(s -> isPalindrome(s)).toList();
        System.out.println(palindroList); //It will give the actual list of the palindrome.

    }
    private static boolean isPalindrome(String s) {
            if (s == null) return false;
            String reversed = new StringBuilder(s).reverse().toString();
            return s.equalsIgnoreCase(reversed);
        }
    
}
