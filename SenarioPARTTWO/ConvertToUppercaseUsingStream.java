package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUppercaseUsingStream {
    public static void main(String[] args) {
        
        List<String> rawString = Arrays.asList("bishal", "barasa", "piggy", "gudu", "shree", "kite", "kitty");

        List<String> upperString = rawString.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperString);
    }
    
}
