package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheSecondLargest {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 34, 35));
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : numList) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest value found.");
        } else {
            System.out.println("Second Largest: " + secondLargest);
        }
    }
    
}
