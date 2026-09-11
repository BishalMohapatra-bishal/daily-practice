package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

public class SkipElementUsingStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("bishal", "barasa", "piggy", "gudu", "shree", "kite");

        words.stream().map(x -> x).skip(2).limit(3).forEach(System.out::println);
    }
}
