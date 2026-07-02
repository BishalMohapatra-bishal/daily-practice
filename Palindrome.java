public class Palindrome {
    public static void main(String[] args) {

        String str = "Level";
        String touppercase = str.toUpperCase();

        int right = touppercase.length() - 1;

        int left = 0;

        boolean isPalindrome = true;
        
        while (left < right) {
            if (touppercase.charAt(left) != touppercase.charAt(right)) {
                isPalindrome = false;
                break;
            }
            right--;
            left++;
        }

        if (isPalindrome) {
            System.out.println(touppercase + " : is a Palindrome.");
        } else {
            System.out.println(touppercase + " : is not a Palindrome.");
        }
    }
}
