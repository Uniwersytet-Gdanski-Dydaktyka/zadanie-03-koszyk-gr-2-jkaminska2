package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    @Test
    void shouldSortByPriceDescThenNameAsc() {
        List<Product> products = List.of(
                new Product("A", "Zebra", 100),
                new Product("B", "Alfa", 100),
                new Product("C", "Omega", 200)
        );
        List<Product> sorted = Sorter.sortByPriceDescNameAsc(products);

        assertEquals("C", sorted.get(0).getCode());
        assertEquals("B", sorted.get(1).getCode());
        assertEquals("A", sorted.get(2).getCode());
    }
}
