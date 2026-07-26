package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("C101", "Toyota Camry", 50.0, 4));
        fleet.add(new Car("C102", "Ford Mustang", 80.0, 2));
        fleet.add(new Car("T201", "Volvo FH", 120.0, 5));

        int rentalDays = 5;
        System.out.println("---- Fleet Rental Summary (" + rentalDays + " Days) ----");

        for (Vehicle vehicle : fleet) {
            vehicle.displayDetails();
            double fee = vehicle.calculateRentalFee(rentalDays);
            System.out.println("Total Fee for " + rentalDays + " days: Rs" + fee);
            System.out.println("---------------------------------------------------------------------");
        }

    }

}

abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private double baseDailyRate;

    public Vehicle(String vehicleId, String brand, double baseDailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        // this.baseDailyRate = baseDailyRate;
        setBaseDailyRate(baseDailyRate);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseDailyRate() {
        return baseDailyRate;
    }

    public void setBaseDailyRate(double baseDailyRate) {

    }

    public abstract double calculateRentalFee(int days);

    void displayDetails() {
        System.out.println("Your chossen vehicle details: \nvehicleId: " + getVehicleId() + "\nBrand: " + getBrand()
                + "\nBaseDailyRate: " + getBaseDailyRate());
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vehicleId, String brand, double baseDailyRate, int numberOfDoors) {
        super(vehicleId, brand, baseDailyRate);
    }

    @Override
    public double calculateRentalFee(int days) {
        double total = getBaseDailyRate() * days;
        if (numberOfDoors == 2) {
            total += 50;
        }
        return total;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Car | Doors: " + numberOfDoors);
    }
}

class Truck extends Vehicle {
    private double loadCapacityTons;

    public Truck(String vehicleId, String brand, double baseDailyRate, double loadCapacityTons) {
        super(vehicleId, brand, baseDailyRate);
        this.loadCapacityTons = loadCapacityTons;
    }

    @Override
    public double calculateRentalFee(int days) {
        double baseFee = getBaseDailyRate() * days;
        double capacitySurcharge = (loadCapacityTons * 20) * days;
        return baseFee + capacitySurcharge;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Truck | Capacity: " + loadCapacityTons + " Tons");
    }
}
