package javamarkt;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PromoBuy2Get1 implements Promotion {

    @Override
    public List<Product> apply(List<Product> products) {
        if (products.size() < 3) return products;

        Product cheapest = products.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(Product::getDiscountPrice))
                .orElse(null);

        if (cheapest == null) return products;

        return products.stream()
                .map(p -> p == cheapest ? p.withDiscountPrice(0.0) : p)
                .collect(Collectors.toList());
    }
}
