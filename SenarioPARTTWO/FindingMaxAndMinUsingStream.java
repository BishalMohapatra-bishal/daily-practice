package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

public class FindingMaxAndMinUsingStream {
    public static void main(String[] args) {
        List<Integer> rawNo = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

       Integer max = rawNo.stream().max(Integer::compareTo).orElseThrow();
       System.out.println(max);

       Integer min = rawNo.stream().min(Integer::compareTo).orElseThrow();
       System.out.println(min);
    }
    
}
