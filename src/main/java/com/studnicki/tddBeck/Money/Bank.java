package com.studnicki.tddBeck.Money;

public class Bank {
    public Money reduce(Expression expression, String currency) {
        return expression.reduce(currency);
    }
}
