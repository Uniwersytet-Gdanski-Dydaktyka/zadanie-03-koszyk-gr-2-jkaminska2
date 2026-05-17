package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PromotionEngineTest {
    @Test
    void shouldApplyAllPromotionsInOrder() {
        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 100)
        );
        PromotionEngine engine = new PromotionEngine();

        engine.add(new PromoOrderDiscount(150, 0.1));
        engine.add(new PromoCoupon("A", 0.5));
        List<Product> result = engine.applyAll(products);

        Product a = result.get(0);
        Product b = result.get(1);

        assertEquals(45, a.getDiscountPrice(), 0.001);
        assertEquals(90, b.getDiscountPrice(), 0.001);
    }
}
