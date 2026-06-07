package rvt.onlineshop;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Product getProduct(String name) {
        for (Product p : this.products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public boolean hasProduct(String name) {
        return getProduct(name) != null;
    }

    public void displayProducts() {
        System.out.println("Produkti noliktavā:");
        for (Product p : this.products) {
            System.out.println("  " + p);
        }
    }
}