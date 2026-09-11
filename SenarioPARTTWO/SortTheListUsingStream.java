package SenarioPARTTWO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTheListUsingStream {
    public static void main(String[] args) {
        List<String> beforeSort = Arrays.asList("Donkey", "Cat", "Apple", "Ball", "Elephant", "Grapes", "Froge");

       List<String> afterSorted = beforeSort.stream()
                                            .sorted()
                                            .toList();
       System.out.println(afterSorted);

       List<String> reverse = beforeSort.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .toList();

        System.out.println(reverse);
    }
}
