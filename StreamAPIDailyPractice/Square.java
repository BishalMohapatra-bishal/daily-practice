package StreamAPIDailyPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square {
    public static void main(String[] args) {
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Integer> squareList = list3.stream().map(x -> x * x).toList();

        System.out.println(squareList);

    }
    
}
