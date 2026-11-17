package hr.lendit.consumer;

import hr.lendit.pricing.LateFee;

public class Main {
    public static void main(String[] args) {
        System.out.println("Late fee for 20 days: " + LateFee.calculate(20));
    }
}
