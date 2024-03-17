// ShoppingCart.java
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    public void addOrder(ItemOrder order) {
        orders.add(order);
    }

    public void removeOrder(String itemName) {
        orders.removeIf(order -> order.getItemName().equals(itemName));
    }

    public double getTotalCost() {
        double total = 0;
        for (ItemOrder order : orders) {
            total += order.getOrderCost();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemOrder order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Cost: $").append(getTotalCost());
        return sb.toString();
    }
}
