package javamarkt;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sorter {

    public static List<Product> sortByPriceDescNameAsc(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(
                        Comparator.comparingDouble(Product::getPrice).reversed()
                                .thenComparing(Product::getName)
                )
                .collect(Collectors.toList());
    }
}

// Logika sortowania jest w osobnej klasie, która zależy od abstrakcji (Comparator),
// a nie od konkretnej implementacji.
// Łatwo dodać nowe sposoby sortowania, dopisując kolejne metody w Sorter.