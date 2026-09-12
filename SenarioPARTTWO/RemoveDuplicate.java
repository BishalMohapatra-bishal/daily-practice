package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> duplicate = new ArrayList<>(Arrays.asList("java", "python", "c++", "c", "pega", "pega", "c++", "c", "python"));

        //This is the modern approach to do it and recomended in modern java
        List<String> orginal = duplicate.stream().distinct().toList();
        System.out.println(orginal);

        //Use this approach if it allow to use another collection
        Set<String> remove = new LinkedHashSet<>(duplicate);
        List<String> remove2 = new ArrayList<>(remove);
        System.out.println(remove2);

        //Use this approach if the interviewer ask to solve this with out using any modern day solution
        List<String> remove3 = new ArrayList<>();
        for(String word : duplicate) {
            if (!remove3.contains(word)) {
                remove3.add(word);
            }
        }
        System.out.println(remove3);

    }
    
}
