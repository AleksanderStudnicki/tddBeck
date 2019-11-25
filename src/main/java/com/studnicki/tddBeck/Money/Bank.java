package com.studnicki.tddBeck.Money;

import java.util.Hashtable;

public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression expression, String currency) {
        return expression.reduce(this, currency);
    }

    public int rate(String from, String to){
        if(from.equals(to)){
            return 1;
        }
        return (Integer) rates.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate){
        rates.put(new Pair(from, to), rate);
    }

}
