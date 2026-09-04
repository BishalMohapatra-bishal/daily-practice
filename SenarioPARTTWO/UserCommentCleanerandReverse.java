package SenarioPARTTWO;

class StringProcessor {

    public boolean isduplicate(String comment1, String comment2) {
        return comment1.trim().equals(comment2.trim());
    }

    public String reverceComment(String comment) {

        StringBuilder sb1 = new StringBuilder(comment);
        String reverseComment = sb1.reverse().toString();

        return reverseComment;
    }

}

public class UserCommentCleanerandReverse {
    
    public static void main(String[] args) {
        String s1 = "Hello";
        // String s3 = "Hello";

        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        StringProcessor sp = new StringProcessor();

        System.out.println(sp.isduplicate(s1, s2));

        System.out.println(sp.reverceComment(s1));
    }
}
