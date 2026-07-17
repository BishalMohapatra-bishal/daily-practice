package StreamAPIDailyPractice;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        int[] numbers = {15, 3, 42, 8, 21, 95, 14, 6};

        int max = Arrays.stream(numbers).max().orElseThrow(() -> new RuntimeException("Array is empty"));

        int min = Arrays.stream(numbers).min().orElseThrow(() -> new RuntimeException("Array is empty"));

        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }
}
