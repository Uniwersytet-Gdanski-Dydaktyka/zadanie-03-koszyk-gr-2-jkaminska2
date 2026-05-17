package javamarkt;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CartUtils {

    public static double sum(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }

    public static Product min(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(Product::getDiscountPrice))
                .orElse(null);
    }

    public static Product max(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Product::getDiscountPrice))
                .orElse(null);
    }

    public static List<Product> nCheapest(List<Product> products, int n) {
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Product::getDiscountPrice))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static List<Product> nMostExpensive(List<Product> products, int n) {
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Product::getDiscountPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}