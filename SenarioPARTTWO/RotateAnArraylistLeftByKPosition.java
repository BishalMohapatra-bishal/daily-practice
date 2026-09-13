package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RotateAnArraylistLeftByKPosition {
    public static void main(String[] args) {
        List<Integer> leftBy = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        int k = 2;
        int n = leftBy.size();
        k = k % n;
        
        List<Integer> rotated = new ArrayList<>();

        for(int i = k; i < n; i++) {
            rotated.add(leftBy.get(i));
        }

        for(int i = 0; i < k; i++) {
            rotated.add(leftBy.get(i));
        }

        System.out.println("Rotated List: " + rotated);
    }
    
}
