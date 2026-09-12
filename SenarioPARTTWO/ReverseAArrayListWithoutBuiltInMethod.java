package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.List;

public class ReverseAArrayListWithoutBuiltInMethod {
    public static void main(String[] args) {
        List<Integer> sequential = new ArrayList<>();
        sequential.add(1);//0
        sequential.add(2);//1
        sequential.add(3);//2
        sequential.add(4);//3
        sequential.add(5);//4
        sequential.add(6);//5
        sequential.add(7);//6
        sequential.add(8);//7
        sequential.add(9);//8
        sequential.add(10);//9
        
        System.out.println("Brfore reversed: " + sequential);

        int start = 0;
        int end = sequential.size() -1;

        while (start < end) {
            int temp = sequential.get(start);
            sequential.set(start, sequential.get(end));
            sequential.set(end, temp);

            start++;
            end--;
        }

        System.out.println("Reversed List: " + sequential);
    }
}
