// import java.util.Arrays;
// import java.util.List;
import java.util.function.Predicate;

public class Pra2 {
    public static void main(String[] args) {
        // Predicate<Integer> pre2 = x -> x > 100000;
        //     System.out.println(pre2.test(1000000000));

        // List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 ,9, 10, 11, 12);
        //     int sum = l1.stream().filter(n -> n % 2 == 0).mapToInt(n -> n ).sum();
        //     System.out.println(sum);

        Predicate<String> startWithLetterB = x -> x.toLowerCase().charAt(0) == 'b';
        Predicate<String> endsWithLetterL = x -> x.toLowerCase().charAt(x.length() - 1) == 'l';

        Predicate<String> and = startWithLetterB.and(endsWithLetterL);
        System.out.println(and.test("Bishal"));


        }
    }
