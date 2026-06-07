package rvt.onlineshop;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product) {
        for (Product p : this.items) {
            if (p.getName().equals(product.getName())) {
                p.reduceQuantity(-product.getQuantity());
                return;
            }
        }
        this.items.add(product);
    }

    public void remove(String productName) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(productName)) {
                this.items.remove(i);
                return;
            }
        }
    }

    public double totalPrice() {
        double total = 0;
        for (Product p : this.items) {
            total += p.totalPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Grozs:");
        for (Product p : this.items) {
            System.out.println("  " + p.getName() + " x" + p.getQuantity() + " = " + p.totalPrice());
        }
        System.out.println("Kopā: " + totalPrice());
    }
}