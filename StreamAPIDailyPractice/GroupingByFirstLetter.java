package StreamAPIDailyPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByFirstLetter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Bishal");
        list.add("Piggy");
        list.add("Barasa");
        list.add("Shreya");
        list.add("Shree");

        Map<Object, List<String>> peopleByFirstLetter = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

        peopleByFirstLetter.forEach((firstLetter, group) -> {
            System.out.println("First Letter : " + firstLetter + " Group:" + group);
        });

        };
    }
    

