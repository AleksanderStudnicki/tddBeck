package com.studnicki.tddBeck.Money;

public interface Expression {
    Money reduce(Bank bank, String currency);
}
