package SenarioPARTTWO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LengthCountUsingStream {
    public static void main(String[] args) {
        
        Set<String> rawWords = new HashSet<>();
        rawWords.add("aaa");
        rawWords.add("bbb");
        rawWords.add("cccc");
        rawWords.add("ddddd");
        rawWords.add("eee");
        rawWords.add("ff");
        rawWords.add("gggggggggg");
        rawWords.add("hhhhhhhhhhhhhhh");
        rawWords.add("ii");
        rawWords.add("sdd");
        rawWords.add("w");

        Set<String> three = rawWords.stream().filter(x -> x.length() > 3).collect(Collectors.toSet());
        System.out.println(three);

        Long count = rawWords.stream().filter(x -> x.length() > 3).count();
        System.out.println(count);
    }
    
}
