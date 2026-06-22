import java.util.ArrayList;
import java.util.List;

public class Pra1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(10);
        list.add(1);
        list.add(4);
        list.add(6);
        System.out.println("List before sorting : " + list);
        list.sort((a, b) -> (b - a));
        System.out.println("List after sortiing in desending order : " + list);
        list.sort((a, b) -> (a - b));
        System.out.println("List after sorting in asending order : " + list);

    }
}
