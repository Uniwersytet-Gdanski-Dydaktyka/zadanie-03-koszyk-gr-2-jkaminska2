package javamarkt;

import java.util.List;
import java.util.stream.Collectors;

public class PromoCoupon implements Promotion {

    private final String productCode;
    private final double percent;

    public PromoCoupon(String productCode, double percent) {
        this.productCode = productCode;
        this.percent = percent;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        return products.stream()
                .map(p -> p.getCode().equals(productCode)
                        ? p.withDiscountPrice(p.getDiscountPrice() * (1 - percent))
                        : p)
                .collect(Collectors.toList());
    }
}