package com.studnicki.tddBeck.Money;

public class Money implements Expression{
    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    public Money times(int multiplier){ return new Money(amount * multiplier, currency);}

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(String currency) {
        return this;
    }
}
