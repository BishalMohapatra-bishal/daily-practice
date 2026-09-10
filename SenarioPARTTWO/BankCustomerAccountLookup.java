package SenarioPARTTWO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Customer {
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }


    public int getCustomerId() {
        return customerId;
    }


    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;    
        return customerId == customer.customerId;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + "]";
    }

}

public class BankCustomerAccountLookup {
    public static void main(String[] args) {
        Map<Customer, Double> accountMap = new HashMap<>();

        Customer c1 = new Customer(101, "Bishal");
        accountMap.put(c1, 1500.00);

        Customer c2 = new Customer(101, "Bishal");

        Double balance = accountMap.get(c2);

        System.out.println("Lookup using c2 reference: Rs " + balance);
        System.out.println("Map size: " + accountMap.size());

    }
}
