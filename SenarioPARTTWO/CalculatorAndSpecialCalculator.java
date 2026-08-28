package SenarioPARTTWO;

class Calculator {

    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public void describe() {
        System.out.println("Standard Calculator.");
    }
}

class AdvanceCalculator extends Calculator {

    @Override
    public void describe() {
        System.out.println("Advance calculator with extra feature.");
    }
}

public class CalculatorAndSpecialCalculator {
    public static void main(String[] args) {
        System.out.println(Calculator.add(2, 2));
        System.out.println(Calculator.add(4.4, 4.4));

        Calculator cal = new AdvanceCalculator();
        cal.describe();
    }
}
