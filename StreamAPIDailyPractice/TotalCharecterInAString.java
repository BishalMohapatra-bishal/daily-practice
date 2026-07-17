package StreamAPIDailyPractice;

import java.util.List;

public class TotalCharecterInAString {
    public static void main(String[] args) {
     List<String> words = List.of("apple", "banana", "cherry");
     
     int totalCharacters = words.stream().mapToInt(String::length).sum();
     System.out.println("Total number of charecters: " + totalCharacters);
    }
}
