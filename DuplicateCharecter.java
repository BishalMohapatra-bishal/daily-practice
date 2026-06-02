public class DuplicateCharecter {
    public static void main(String[] args) {
        String str = "LeveL";
        boolean isPalindrome = true;
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(str +" is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }
    }
    
}
