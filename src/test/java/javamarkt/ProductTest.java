package javamarkt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void constructorShouldSetFieldsCorrectly() {
        Product p = new Product("A1", "Myszka", 100);

        assertEquals("A1", p.getCode());
        assertEquals("Myszka", p.getName());
        assertEquals(100, p.getPrice());
        assertEquals(100, p.getDiscountPrice());
    }

    @Test
    void withDiscountPriceShouldCreateNewObject() {
        Product p1 = new Product("A1", "Myszka", 100);
        Product p2 = p1.withDiscountPrice(70);

        assertEquals(100, p1.getDiscountPrice());
        assertEquals(70, p2.getDiscountPrice());
        assertNotSame(p1, p2);
    }
}
