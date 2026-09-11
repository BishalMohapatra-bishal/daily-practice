package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatenateStringUsingStream {
    public static void main(String[] args) {
        List<String> rawWords = Arrays.asList("B", "I", "S", "H", "A", "L");

        String single = rawWords.stream().collect(Collectors.joining("_"));
        System.out.println(single);
    }
}
