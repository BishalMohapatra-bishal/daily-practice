public class ReverseString {
    public static void main(String[] args) {
        String original = "Barasa";

        String reverse = "";

        for(int i = original.length() - 1; i >= 0; i--) {
           reverse += original.charAt(i);
        }
        System.out.println(original);
        System.out.println(reverse);

    }

    
}
