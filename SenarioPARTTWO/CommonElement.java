package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElement {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));

        List<Integer> common = new ArrayList<>(list1);
        common.retainAll(list2);
        System.out.println("Common elements are: " + common);
    }
    
}
