package JAVA8AllFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        // Consumer<String> consumer = s -> System.out.println(s);
        // consumer.accept("Bishal"); 

        Consumer<List<Integer>> listConsumer1 = li -> {
            for(Integer i : li) {
                System.out.println(i + 100);
            }
        };
        Consumer<List<Integer>> listConsumer2 = x -> {
            for(Integer j : x) {
                System.out.println(j);
            }
        };
        listConsumer2.andThen(listConsumer1).accept(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
