import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Supll1 {
    public static void main(String[] args) {
        Supplier<Integer> supp = () -> 145678;
        System.out.println(supp.get());

        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = ii -> ii * ii;
        Consumer<Integer> c = iii -> System.out.println(iii);
        Supplier<Integer> s = () -> 100;

        if (p.test(s.get())) {
            c.accept(f.apply(s.get()));
        }
    }
    
}
