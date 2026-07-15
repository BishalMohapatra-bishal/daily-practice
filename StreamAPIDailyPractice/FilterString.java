package StreamAPIDailyPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterString {
    public static void main(String[] args) {
        List<String> fl = new ArrayList<>();
        fl.add("Subham");
        fl.add("Bishal");
        fl.add("Awesh");
        fl.add("Akash");
        fl.add("Bibhu");
        fl.add("Hritik");
        fl.add("Rinku");
        fl.add("Siroj");
        fl.add("Crown");

        fl.stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.contains("a"))
                // .forEach(s -> System.out.println(s));
                .forEach(System.out::println); // using method reference

    }
}
