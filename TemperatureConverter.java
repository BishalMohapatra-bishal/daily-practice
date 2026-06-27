import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Calling our method
        double fahrenheit = convertToFahrenheit(celsius);

        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");

        sc.close();
    }

    // This method handles the logic
    public static double convertToFahrenheit(double c) {
        return (c * 9.0 / 5.0) + 32;
    }
}

