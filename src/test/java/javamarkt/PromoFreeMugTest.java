package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PromoFreeMugTest {
    @Test
    void shouldAddMugWhenAboveThreshold() {
        Promotion promo = new PromoFreeMug(200);

        List<Product> products = List.of(
                new Product("A", "A", 150),
                new Product("B", "B", 100)
        );
        List<Product> result = promo.apply(products);

        assertEquals(3, result.size());
        assertEquals("MUG", result.get(2).getCode());
    }
}
