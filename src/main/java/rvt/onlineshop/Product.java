
package rvt.onlineshop;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalPrice() {
        return this.price * this.quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
        }
    }

    @Override
    public String toString() {
        return this.name + ", price " + this.price + ", quantity " + this.quantity;
    }
}