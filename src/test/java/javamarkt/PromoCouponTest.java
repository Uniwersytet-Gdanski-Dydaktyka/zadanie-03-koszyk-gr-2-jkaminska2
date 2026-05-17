package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PromoCouponTest {

    @Test
    void shouldApplyCouponToCorrectProduct() {
        Promotion promo = new PromoCoupon("A", 0.3);

        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 100)
        );
        List<Product> result = promo.apply(products);

        assertEquals(70, result.get(0).getDiscountPrice());
        assertEquals(100, result.get(1).getDiscountPrice());
    }
}
