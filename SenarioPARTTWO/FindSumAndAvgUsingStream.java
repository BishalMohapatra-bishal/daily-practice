package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

public class FindSumAndAvgUsingStream {
    public static void main(String[] args) {
        List<Integer> no = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       int sum = no.stream()
                   .mapToInt(Integer::intValue)
                   .sum();
                   System.out.println(sum);

       double avg = no.stream()
                      .mapToDouble(Integer::intValue)
                      .average()
                      .orElse(0.0);
                      System.out.println(avg);   
    }
}
