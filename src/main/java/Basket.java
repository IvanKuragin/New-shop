import java.util.Map;

public class Basket {
    protected Purchase[] purchases;
    public Basket(int basketSize) {
        this.purchases = new Purchase[basketSize];
    }
    public void addPurchase (String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].getTitle().equals(title)) {
                int countBasket = purchases[i].getCount();
                purchases[i].setCount(countBasket += count);
                return;
            }
        }
    }
    public long sum (Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА: ");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if(purchase == null) continue;
            System.out.println("\t" + purchase.getTitle() + " "
                    + purchase.getCount() + " шт. в сумме "
                    + (purchase.getCount() * prices.get(purchase.getTitle())) + " руб.");
            sum += (long) purchase.getCount() * prices.get(purchase.getTitle());
        }
        return sum;
    }
}
