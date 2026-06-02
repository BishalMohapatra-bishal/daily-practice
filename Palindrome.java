public class Palindrome {
    public static void main(String[] args) {

        String str = "LeveL";

        int right = str.length() - 1;

        int left = 0;

        boolean isPalindrome = true;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }
            right--;
            left++;
        }

        if (isPalindrome) {
            System.out.println(str + " : is a Palindrome.");
        } else {
            System.out.println(str + " : is not a Palindrome.");
        }
    }
}
