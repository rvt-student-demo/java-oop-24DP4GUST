package rvt.InterfaceInABox;

import java.util.ArrayList;

public class Box implements Packable {
    private double maxWeight;
    private ArrayList<Packable> items;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    public double weight() {
        double total = 0;
        for (Packable item : this.items) {
            total += item.weight();
        }
        return total;
    }

    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}