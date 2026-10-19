package InterviewQuestions;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    public static void main(String[] args) {
        ValidPalindrome pa = new ValidPalindrome();

        if (pa.isPalindrome("KATAK")) {
            System.out.println("Is a palindromr");
        } else {
            System.out.println("Not a palindrome");
        }
    }
    
}
