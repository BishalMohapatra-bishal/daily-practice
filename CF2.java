import java.util.ArrayList;
import java.util.Comparator;

public class CF2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

//        This is using a separate class which implement the comparator class
//        list.sort(new ComparatorImplementation());

//        This is using the lambda expression because the sort method take a comparator
        list.sort((o1, o2) -> o1 - o2);
        System.out.println(list);
    }
}

class ComparatorImplementation implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
