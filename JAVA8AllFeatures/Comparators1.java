import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparators1 {

  public static void main(String[] args) {
        List<String> wl = Arrays.asList("Bishal", "Barasa", "Shree", "Apple", "Banana", "zoo", "zzzzzzzzzzzzzzzzzzzzzzzzzzz");
        List<Integer> nl = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        wl.sort((a, b) -> a.length() - b.length());
        nl.sort((a, b) -> b - a);
        System.out.println(wl);
        System.out.println(nl);
    } 
    
    
}

// class WordaList implements Comparator<Integer>{
//      @Override
//     public int compare(Integer o1, Integer o2) {
        
//         return o1. - 02;
//     }   
// }
