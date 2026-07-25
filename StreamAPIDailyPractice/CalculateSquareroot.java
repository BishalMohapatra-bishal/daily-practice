package StreamAPIDailyPractice;

import java.util.List;

public class CalculateSquareroot {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);

       
       List<Integer> squareList =  list.stream().map(x -> x * x).toList();
       System.out.println(squareList);
    }
    
}
