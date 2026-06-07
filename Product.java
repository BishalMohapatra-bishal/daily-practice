package TheDuplicateProductCatalog;

import java.util.TreeSet;

public class Product {
    public static void main(String[] args) {
        TreeSet<String> productList = new TreeSet<>();
        productList.add("Mixture");
        productList.add("Coffee");
        productList.add("Mixture");
        productList.add("Coffee");
        productList.add("Tea");
        productList.add("Apple");

        for (String p : productList) {
            System.out.println(p);
        }
    }
}
