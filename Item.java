// Item.java
public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
}


    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getOrderCost() {
        return item.getPrice() * quantity; // 
    }

    public String getItemName() {
        return item.getName();
    }

    @Override
    public String toString() {
        return quantity + "x " + item.getName() + " for $" + getOrderCost();
    }
}

