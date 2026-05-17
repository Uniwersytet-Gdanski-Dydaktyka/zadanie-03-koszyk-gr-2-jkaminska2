package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PromoOrderDiscountTest {
    @Test
    void shouldNotApplyDiscountWhenBelowThreshold() {
        Promotion promo = new PromoOrderDiscount(300, 0.05);

        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 100)
        );
        List<Product> result = promo.apply(products);

        assertEquals(100, result.get(0).getDiscountPrice());
        assertEquals(100, result.get(1).getDiscountPrice());
    }

    @Test
    void shouldApplyDiscountWhenAboveThreshold() {
        Promotion promo = new PromoOrderDiscount(150, 0.1);

        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 100)
        );
        List<Product> result = promo.apply(products);

        assertEquals(90, result.get(0).getDiscountPrice());
        assertEquals(90, result.get(1).getDiscountPrice());
    }
}
