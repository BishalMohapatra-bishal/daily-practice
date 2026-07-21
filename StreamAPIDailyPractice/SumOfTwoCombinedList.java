package StreamAPIDailyPractice;

import java.util.List;
import java.util.stream.Stream;

public class SumOfTwoCombinedList {

    public static void main(String[] args) {
        List<Integer> List1 = List.of(1, 3, 5, 7, 9, 11, 13, 15);
        List<Integer> List2 = List.of(2, 4, 6, 8, 10, 12, 14, 16);

        int sumOfCombinedList = Stream.concat(List1.stream(), List2.stream()).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfCombinedList);        
    }
    
}
