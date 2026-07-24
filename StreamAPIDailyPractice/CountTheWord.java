package StreamAPIDailyPractice;

// import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTheWord {
    public static void main(String[] args) {

        List<String> wordsList = List.of("Barasa", "Piggy", "Hipo", "Hathee", "Piggy", "Hipo", "Barasa");

        // Map<String, Integer> wordCounts = new HashMap<>();


        // for (String word : wordsList) {
        //     wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        // }

        // for(Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
        
        Map<String, Long> wordCounts2 = wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCounts2.forEach((word, count) -> 
        System.out.println(word + ": " + count)
    );
    }
}
