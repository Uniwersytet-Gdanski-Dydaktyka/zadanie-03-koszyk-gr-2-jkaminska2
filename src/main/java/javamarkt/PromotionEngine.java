package javamarkt;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngine {

    private final List<Promotion> promotions = new ArrayList<>();

    public void add(Promotion p) {
        if (p != null) promotions.add(p);
    }

    public List<Product> applyAll(List<Product> products) {
        List<Product> result = products;
        for (Promotion p : promotions) {
            result = p.apply(result);
        }
        return result;
    }
}
