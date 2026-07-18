package StreamAPIDailyPractice;

import java.util.List;

public class Touppercase {
    public static void main(String[] args) {
        List<String> listOfWords = List.of("bishal", "barasa", "gudu", "piggy");

        List<String> upperCaseList = listOfWords.stream().map(x -> x.toUpperCase()).toList();
        System.out.println(upperCaseList);
    }
}