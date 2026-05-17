package javamarkt;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PromoOrderDiscount implements Promotion {

    private final double threshold;
    private final double percent;

    public PromoOrderDiscount(double threshold, double percent) {
        this.threshold = threshold;
        this.percent = percent;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        double sum = products.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Product::getDiscountPrice)
                .sum();

        if (sum <= threshold) return products;

        return products.stream()
                .map(p -> p.withDiscountPrice(p.getDiscountPrice() * (1 - percent)))
                .collect(Collectors.toList());
    }
}
