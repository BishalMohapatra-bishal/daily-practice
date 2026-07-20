package StreamAPIDailyPractice;

import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(2, 4, 7, 10, 11, 15, 19, 20, 23, 29, 30);

        System.out.println("Prime numbers in the list:");

        numbers.stream()
        .filter(n -> isPrime(n))
        .forEach(System.out::println);
    }    

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        return IntStream
        .rangeClosed(2, (int) Math
        .sqrt(number))
        .noneMatch(i -> number % i == 0);
    }
    
}
