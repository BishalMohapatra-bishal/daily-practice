import java.util.ArrayList;
import java.util.List;

public class FilterEmp {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        Employee e1 = new Employee("Bishal1", 30000);
        Employee e2 = new Employee("Gudu1", 35000);
        Employee e3 = new Employee("Bishal2", 55000);
        Employee e4 = new Employee("Gudu2", 50000);
        Employee e5 = new Employee("Bishal3", 80000);
        Employee e6 = new Employee("Gudu3", 25000);

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);

        List<String> empName =  empList.stream()
                        .filter(x -> x.getSalary() >= 50000)
                        .map(Employee::getName)
                        .toList();
        System.out.println(empName);
    }
}

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
