package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

public class FindPositiveAndNegativeNoUsingStream {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, -5, -6, 7, 8, 9, 10);

        boolean hasNegative = num.stream().anyMatch(x -> x < 0);
        System.out.println(hasNegative);

        boolean hasPositive = num.stream().allMatch(x -> x > 0);
        System.out.println(hasPositive);
    }
    
}
