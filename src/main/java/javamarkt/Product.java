package javamarkt;

import java.util.Objects;

public final class Product {
    private final String code;
    private final String name;
    private final double price;
    private final double discountPrice;
    // Klasa niemutowalna, żeby promocje nie nachodziły na siebie i nie psuły wyników.
    // Product przechowuje dane, a logika promocji jest w osobnych klasach.

    public Product(String code, String name, double price) {
        this(code, name, price, price);
    }

    public Product(String code, String name, double price, double discountPrice) {
        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscountPrice() { return discountPrice; }

    public Product withDiscountPrice(double newDiscountPrice) {
        return new Product(code, name, price, newDiscountPrice);
    }
}

// Wzorzec Strategy - promocje mogą się zmieniać w trakcie działania programu.
// Dodanie nowej promocji wymaga tylko dopisania nowej klasy.
// Logika promocji jest odseparowana od logiki koszyka.
// Wzorzec Comand byłby nadmiarem, ponieważ:
// - nie wymagamy cofania promocji
// - nie wymagamy kolejkowania operacji
// - wystarczy zastosować promocje w koreślonej kolejności