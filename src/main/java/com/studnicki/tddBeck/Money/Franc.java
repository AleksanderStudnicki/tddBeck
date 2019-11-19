package com.studnicki.tddBeck.Money;

public class Franc extends Money {
    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int i) {
        return new Franc(amount * i);
    }
}
