import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numberWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3));
        System.out.println("Original List: " + numberWithDuplicates);

        Set<Integer> set = new LinkedHashSet<>(numberWithDuplicates);

        List<Integer> numbersWithoutDuplicates = new ArrayList<>(set);

        System.out.println("List after removing duplicates: " + numbersWithoutDuplicates);
    }
}
