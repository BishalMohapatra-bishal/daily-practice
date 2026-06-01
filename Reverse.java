public class Reverse {
    public static void main(String[] args) {
        String reverse = "Bishal";
        StringBuilder result = new StringBuilder();

        for (int i = reverse.length() - 1; i >= 0; i--) {
            result.append(reverse.charAt(i));
        }
        System.out.println(result.toString());
    }
}
