package SenarioPARTTWO;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
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
}

class DepartmentAnalyticsService {

    public Map<String, List<String>> getEmployeeNamesByDepartment(List<Employee> employees) {
        return employees.stream()
                        .collect(Collectors
                            .groupingBy(Employee::getDepartment, Collectors
                                .mapping(Employee::getName, Collectors
                                    .toList())));
    }

    public Map<String, Double> getTotalSalaryByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
    }
}

public class DepartmentSalaryAndEmployeeAggregates {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
          new Employee(1, "Bishal", "IT", 75000),
          new Employee(2, "Amit", "HR", 50000),
          new Employee(3, "Priya", "IT", 85000),
          new Employee(4, "Rahul", "Finance", 60000),
          new Employee(5, "Sneha", "HR", 55000)  
        );

        DepartmentAnalyticsService service = new DepartmentAnalyticsService();

        System.out.println("--- Employee Grouped by Department ---");
        Map<String, List<String>> deptEmployees = service.getEmployeeNamesByDepartment(employees);
        deptEmployees.forEach((dept, names) -> System.out.println(dept + ": " + names));

        System.out.println("\n--- Total Salary Payout by Department ---");
        Map<String, Double> deptSalaries = service.getTotalSalaryByDepartment(employees);
        deptSalaries.forEach((dept, total) -> System.out.printf("%s: $%.2f%n", dept, total));
    }
}



