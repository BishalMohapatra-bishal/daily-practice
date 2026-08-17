package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private double rating;

    public Employee(int id, String name, String department, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public double getRating() {
        return rating;
    }

}

class HRProcessor {
    public List<String> getEligibleBounusEmployees(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return new ArrayList<>();
        }

        return employees.stream()
                .filter(emp -> emp.getRating() >= 4.0)
                .map(emp -> {
                    double bonus = emp.getSalary() * 0.10;
                    return String.format("Name: %s | Dept: %s | Bonus: $%.2f",
                            emp.getName(), emp.getDepartment(), bonus);
                })
                .collect(Collectors.toList());

    }
}

public class EmployeePerformanceandBonusEligibilityProcessor {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
            new Employee(101, "Amit", "IT", 75000.0, 4.5),      
            new Employee(102, "Priya", "HR", 50000.0, 3.8),     
            new Employee(103, "Bishal", "IT", 85000.0, 4.8),    
            new Employee(104, "Suman", "Sales", 60000.0, 3.2),  
            new Employee(105, "Anita", "Finance", 90000.0, 4.2) 
        );

        HRProcessor p1 = new HRProcessor();
       List<String> bonusList =  p1.getEligibleBounusEmployees(employeeList);

       System.out.println("----- High Performers Bonus List -----");
       bonusList.forEach(System.out::println);
    }

}
