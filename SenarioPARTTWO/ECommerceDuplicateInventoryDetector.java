package SenarioPARTTWO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Product {

    private final int productId;
    private final String skuCode;
    private final double price;

    public Product(int productId, String skuCode, double price) {
        this.productId = productId;
        this.skuCode = skuCode;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId;
        result = prime * result + ((skuCode == null) ? 0 : skuCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        if (skuCode == null) {
            if (other.skuCode != null)
                return false;
        } else if (!skuCode.equals(other.skuCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", skuCode=" + skuCode + ", price=" + price + "]";
    }

    
}

class InventoryService {
    public int processInventory(List<Product> incomingProducts) {
        Set<Product> productCount = new HashSet<>(incomingProducts);
        return productCount.size();
    }
}
public class ECommerceDuplicateInventoryDetector {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(101, "SKU-A", 25.0),
            new Product(102,  "SKU-B", 40.0),
            new Product(101, "SKU-A", 30.0),
            new Product(103, "SKU-C", 15.0)
        );

        InventoryService in1 = new InventoryService();
        System.out.println("Total unique product count is: " + in1.processInventory(products));
    }
}
