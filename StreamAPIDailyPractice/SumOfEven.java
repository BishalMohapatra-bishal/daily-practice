package StreamAPIDailyPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfEven {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int sum = list.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();

        System.out.println(sum);

    }
}
