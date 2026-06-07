package rvt;
public class IOweYou {
    private double amountOwed;

    public IOweYou() {
        this.amountOwed = 0;
    }

    public void setLoan(double amount) {
        this.amountOwed = amount;
    }

    public double howMuchIsOwed() {
        return this.amountOwed;
    }

    public void pay(double amount) {
        if (amount > 0) {
            this.amountOwed -= amount;
            if (this.amountOwed < 0) {
                this.amountOwed = 0;
            }
        }
    }
}