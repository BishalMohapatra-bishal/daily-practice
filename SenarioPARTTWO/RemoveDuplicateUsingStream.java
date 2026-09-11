package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RemoveDuplicateUsingStream {
    public static void main(String[] args) {
    List<String> duplicate = Arrays.asList("bishal", "barasa", "piggy", "gudu", "barasa", "bishal");

    List<String> unique = duplicate.stream().distinct().toList();
    System.out.println(unique);
    }
}
