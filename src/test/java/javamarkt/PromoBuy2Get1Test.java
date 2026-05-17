package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PromoBuy2Get1Test {
    @Test
    void shouldGiveCheapestProductForFree() {
        Promotion promo = new PromoBuy2Get1();

        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 50),
                new Product("C", "C", 200)
        );
        List<Product> result = promo.apply(products);

        assertEquals(0, result.get(1).getDiscountPrice());
    }
}
