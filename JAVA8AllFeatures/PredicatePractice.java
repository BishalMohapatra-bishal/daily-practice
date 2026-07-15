package JAVA8AllFeatures;

import java.util.function.Predicate;

public class PredicatePractice {
    public static void main(String[] args) {
        Predicate<Integer> pred1 = (x -> x > 100000);
        System.out.println(pred1.test(1000000));

        Predicate<String> pred2 = x -> x.toLowerCase().charAt(0) == 'B';
        Predicate<String> pred3 = x -> x.toLowerCase().charAt(x.length() -1) == 'L';

        Predicate<String> pred4 = pred2.and(pred3);
        System.out.println(pred4.test("Bishal"));

        Predicate<String> pred5 = pred2.or(pred3);
        System.out.println(pred5.test("Bishal"));
    }
}
