package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

class ProductService {
    public List<Double> getDiscountedPrice(List<Double> rawPrice) {
      return rawPrice.stream()
                .filter(price -> price <= 100)
                .map(rPrice -> rPrice * 0.90)
                .toList();
    }
}

public class ProductPriceDiscountAndFiltering {
 public static void main(String[] args) {
    List<Double> rawPrice = Arrays.asList(50.0, 120.0, 80.0, 200.0, 150.0, 55.0);

    ProductService service = new ProductService();
    List<Double> disPrice = service.getDiscountedPrice(rawPrice);

    System.out.println("Raw prices : " + rawPrice);
    System.out.println("Discounted price : " + disPrice);
 }   
}
