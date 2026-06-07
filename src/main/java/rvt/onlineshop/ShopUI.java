package rvt.onlineshop;

import java.util.Scanner;

public class ShopUI {
    private Warehouse warehouse;
    private ShoppingCart cart;
    private Scanner scanner;

    public ShopUI() {
        this.warehouse = new Warehouse();
        this.cart = new ShoppingCart();
        this.scanner = new Scanner(System.in);
        
        // Pievienojam produktus
        warehouse.addProduct(new Product("Ābols", 0.5, 100));
        warehouse.addProduct(new Product("Maize", 1.2, 50));
        warehouse.addProduct(new Product("Piens", 0.9, 30));
        warehouse.addProduct(new Product("Sviests", 1.5, 20));
    }

    public void start() {
        while (true) {
            System.out.println("\n=== ONLINE SHOP ===");
            System.out.println("1. Apskatīt produktus");
            System.out.println("2. Pievienot grozam");
            System.out.println("3. Izņemt no groza");
            System.out.println("4. Apskatīt grozu");
            System.out.println("5. Apmaksāt");
            System.out.println("6. Iziet");
            System.out.print("Izvēlies: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice == 1) {
                warehouse.displayProducts();
            } else if (choice == 2) {
                System.out.print("Produkta nosaukums: ");
                String name = scanner.nextLine();
                if (warehouse.hasProduct(name)) {
                    Product p = warehouse.getProduct(name);
                    System.out.print("Daudzums: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity <= p.getQuantity()) {
                        cart.add(new Product(p.getName(), p.getPrice(), quantity));
                        p.reduceQuantity(quantity);
                        System.out.println("Pievienots grozam!");
                    } else {
                        System.out.println("Nepietiek daudzuma noliktavā!");
                    }
                } else {
                    System.out.println("Produkts nav atrasts!");
                }
            } else if (choice == 3) {
                System.out.print("Produkta nosaukums izņemšanai: ");
                String name = scanner.nextLine();
                cart.remove(name);
                System.out.println("Izņemts no groza!");
            } else if (choice == 4) {
                cart.displayCart();
            } else if (choice == 5) {
                Order order = new Order(cart);
                order.pay();
                cart = new ShoppingCart();
            } else if (choice == 6) {
                System.out.println("Paldies par iepirkšanos!");
                break;
            }
        }
    }
}