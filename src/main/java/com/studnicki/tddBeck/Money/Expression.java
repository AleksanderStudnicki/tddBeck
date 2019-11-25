package com.studnicki.tddBeck.Money;

public interface Expression {
    Money reduce(Bank bank, String currency);
    Expression times(int multiplier);
    Expression plus(Expression expression);
}
