package javamarkt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Product("P1", "Myszka", 100));
        cart.add(new Product("P2", "Klawiatura", 150));
        cart.add(new Product("P3", "Monitor", 600));

        List<Product> sorted = Sorter.sortByPriceDescNameAsc(cart);
        System.out.println("Posortowane produkty:");
        for (Product p : sorted) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        PromotionEngine engine = new PromotionEngine();
        engine.add(new PromoOrderDiscount(300, 0.05)); // 5% powyżej 300
        engine.add(new PromoBuy2Get1()); // 2+1
        engine.add(new PromoFreeMug(200)); // kubek powyżej 200
        engine.add(new PromoCoupon("P2", 0.30)); // 30% na P2

        List<Product> afterPromos = engine.applyAll(cart);

        System.out.println("\nPo promocjach:");
        for (Product p : afterPromos) {
            System.out.println(p.getCode() + " - " + p.getName()
                    + " | price=" + p.getPrice()
                    + " | discountPrice=" + p.getDiscountPrice());
        }

        double sum = CartUtils.sum(afterPromos);
        System.out.println("\nSuma po promocjach: " + sum);
    }
}

//Posortowane produkty:
//Monitor - 600.0
//Klawiatura - 150.0
//Myszka - 100.0

//Po promocjach:
//P1 - Myszka | price=100.0 | discountPrice=0.0
//P2 - Klawiatura | price=150.0 | discountPrice=99.75
//P3 - Monitor | price=600.0 | discountPrice=570.0
//MUG - Kubek | price=0.0 | discountPrice=0.0

//Suma po promocjach: 669.75