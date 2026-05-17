package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BestPromotionOrderTest {

    @Test
    void shouldFindBestPromotionOrderAmongPermutations() {

        List<Product> cart = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 100),
                new Product("C", "C", 100)
        );

        List<Promotion> promotions = List.of(
                new PromoOrderDiscount(200, 0.10),
                new PromoBuy2Get1(),
                new PromoCoupon("A", 0.30)
        );

        List<Product> best = BestPromotionOrder.applyInBestOrder(cart, promotions);

        double sum = CartUtils.sum(best);

        assertTrue(sum <= 200);
    }
}
