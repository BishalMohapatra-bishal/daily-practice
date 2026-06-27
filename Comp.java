import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);
        list.add(100);
        
        Collections.sort(list, (a, b) -> b - a); 

        System.out.println(list);
    }
}