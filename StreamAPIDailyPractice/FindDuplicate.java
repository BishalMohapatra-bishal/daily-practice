package StreamAPIDailyPractice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);

        List<Integer> duplicateList1 = list.stream().map(x -> x).distinct().toList();
        System.out.println(duplicateList1); 
        // This approach is wrong because .distinct() method only return the unique element and separate the repete element.
        
        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicateList = list.stream().filter(n -> !seen.add(n)).distinct().toList();

        System.out.println(duplicateList);
    }
    
}
