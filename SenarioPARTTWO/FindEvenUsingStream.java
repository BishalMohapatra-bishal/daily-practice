package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

public class FindEvenUsingStream {
    public static void main(String[] args) {
        
        List<Integer> rawList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<Integer> even = rawList.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(even);
    }
    
}
