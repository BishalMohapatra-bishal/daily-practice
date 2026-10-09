import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer1 {
    public static void main(String[] args) {
        Consumer<String> consumer = c -> System.out.println(c);
        consumer.accept("Bishal");

        Consumer<List<Integer>> consumerList = li -> {
            for(Integer i : li) {
                System.out.println(i + 100);
            }
        };

        Consumer<List<Integer>> consumerList2 = li2 -> {
            for(Integer ii : li2) {
                System.out.println(ii);
            }
        };

        consumerList.andThen(consumerList2).accept(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // consumerList.accept(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
    
}
