// import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Fizz-Buzz - " + i);
            } else if (i % 3 == 0) {
                System.out.println("Fuzz - " + i);
            } else if (i % 5 == 0){
                System.out.println("Buzz - " + i);
            } else {
                System.out.println("Remain Numbers - " + i);
            }
        }
    }
}
