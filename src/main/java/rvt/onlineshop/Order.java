package rvt.onlineshop;

public class Order {
    private ShoppingCart cart;
    private boolean paid;

    public Order(ShoppingCart cart) {
        this.cart = cart;
        this.paid = false;
    }

    public double totalPrice() {
        return this.cart.totalPrice();
    }

    public void pay() {
        this.paid = true;
        System.out.println("Pasūtījums apmaksāts! Summa: " + totalPrice());
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void displayOrder() {
        System.out.println("Pasūtījums:");
        this.cart.displayCart();
        System.out.println("Apmaksāts: " + (this.paid ? "Jā" : "Nē"));
    }
}