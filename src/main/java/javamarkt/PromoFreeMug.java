package javamarkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PromoFreeMug implements Promotion {

    private final double threshold;

    public PromoFreeMug(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        double sum = products.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Product::getDiscountPrice)
                .sum();

        if (sum <= threshold) return products;

        List<Product> result = new ArrayList<>(products);
        result.add(new Product("MUG", "Kubek", 0.0));
        return result;
    }
}
