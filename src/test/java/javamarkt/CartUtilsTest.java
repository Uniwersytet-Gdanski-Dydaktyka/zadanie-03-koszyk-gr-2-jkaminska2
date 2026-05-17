package javamarkt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CartUtilsTest {
    @Test
    void sumShouldWork() {
        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 50)
        );

        assertEquals(150, CartUtils.sum(products));
    }
}