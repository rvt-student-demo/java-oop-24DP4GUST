package rvt;
public class Main {
    public static void main(String[] args) {
        IOweYou owe = new IOweYou();
        
        owe.setLoan(50);
        System.out.println("Parāds: " + owe.howMuchIsOwed());
        
        owe.pay(20);
        System.out.println("Pēc 20 maksājuma: " + owe.howMuchIsOwed());
        
        owe.pay(40);
        System.out.println("Pēc 40 maksājuma: " + owe.howMuchIsOwed());
    }
}


