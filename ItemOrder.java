// ItemOrder.java
public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getOrderCost() {
        return item.getPrice() * quantity; // Simplified for the general case; adjust for bulk pricing as needed
    }

    public String getItemName() {
        return item.getName();
    }

    @Override
    public String toString() {
        return quantity + "x " + item.getName() + " for $" + getOrderCost();
    }
}
