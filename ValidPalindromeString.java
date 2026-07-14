public class ValidPalindromeString {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            else {
                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));

                if (leftChar != rightChar) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";

        System.out.println("Test 1 is palindrome? " + isPalindrome(test1));
        System.out.println("Test 2 is palindrome? " + isPalindrome(test2));
    }
}