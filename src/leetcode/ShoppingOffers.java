package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingOffers {


    public static void main(String[] args) {

        final int result = new ShoppingOffers().shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1));
        System.out.println(result);

    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price.isEmpty()) {
            return 0;
        }
        if (special.isEmpty()) {
            int simplePurchase = 0;
            for (int i = 0; i < needs.size(); i++) {
                simplePurchase += needs.get(i) * price.get(i);
            }
            return simplePurchase;
        }

        final List<Offer> offers = special.stream().map(l -> new Offer(l.get(l.size() - 1), l.subList(0, l.size() - 1))).collect(Collectors.toList());
        return shoppingOffers_(price, offers, needs);
    }


    public int shoppingOffers_(List<Integer> price, List<Offer> offers, List<Integer> needs) {
        if (needs.isEmpty()) {
            return 0;
        }
        int simplePurchase = 0;
        for (int i = 0; i < needs.size(); i++) {
            simplePurchase += needs.get(i) * price.get(i);
        }
        int min = simplePurchase;
        for (Offer o : offers) {
            if (o.canApplyOffer(needs)) {
                System.out.println("Applying offer:" + o + ":" + needs);
                final Spent spentOnOffer = o.applyOffer(needs);
                System.out.println(spentOnOffer);
                final int furtherSpent = shoppingOffers_(price, offers, spentOnOffer.remNeeds);
                if (furtherSpent != Integer.MAX_VALUE) {
                    min = Math.min(min, spentOnOffer.amount + furtherSpent);
                }
            } else {
                System.out.println("Applying offer:" + o + ":" + needs + " Failed");
            }
        }
        System.out.println(min);
        return min;
    }

    class Offer {
        int price;
        List<Integer> noOfEachItems;

        public Offer(int price, List<Integer> noOfEachItems) {
            this.price = price;
            this.noOfEachItems = noOfEachItems;
        }

        public boolean canApplyOffer(List<Integer> needs) {
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < noOfEachItems.get(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return "Offer{" +
                    "price=" + price +
                    ", noOfEachItems=" + noOfEachItems +
                    '}';
        }

        public Spent applyOffer(List<Integer> needs) {
            List<Integer> remNeeds = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                final Integer count = noOfEachItems.get(i);
                remNeeds.add(needs.get(i) - count);
            }
            return new Spent(price, remNeeds);
        }

    }

    class Spent {
        int amount;
        List<Integer> remNeeds;

        public Spent(int amount, List<Integer> remNeeds) {
            this.amount = amount;
            this.remNeeds = remNeeds;
        }

        @Override
        public String toString() {
            return "Spent{" +
                    "amount=" + amount +
                    ", remNeeds=" + remNeeds +
                    '}';
        }
    }
}
