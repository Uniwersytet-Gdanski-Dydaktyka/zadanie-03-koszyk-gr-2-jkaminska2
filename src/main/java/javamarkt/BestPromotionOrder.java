package javamarkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestPromotionOrder {

    public static List<Product> applyInBestOrder(List<Product> originalCart,
                                                 List<Promotion> promotions) {

        List<List<Promotion>> allOrders = generatePermutations(promotions);

        List<Product> bestResult = originalCart;
        double bestSum = CartUtils.sum(originalCart);

        for (List<Promotion> order : allOrders) {
            List<Product> result = applyAll(originalCart, order);
            double sum = CartUtils.sum(result);

            if (sum < bestSum) {
                bestSum = sum;
                bestResult = result;
            }
        }

        return bestResult;
    }

    private static List<Product> applyAll(List<Product> cart, List<Promotion> promotions) {
        List<Product> result = cart;
        for (Promotion p : promotions) {
            result = p.apply(result);
        }
        return result;
    }

    private static List<List<Promotion>> generatePermutations(List<Promotion> promotions) {
        List<List<Promotion>> result = new ArrayList<>();
        permute(promotions, 0, result);
        return result;
    }

    private static void permute(List<Promotion> arr, int index, List<List<Promotion>> result) {
        if (index == arr.size() - 1) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            permute(arr, index + 1, result);
            Collections.swap(arr, i, index);
        }
    }
}
