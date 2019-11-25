import com.studnicki.tddBeck.Money.Bank;
import com.studnicki.tddBeck.Money.Expression;
import com.studnicki.tddBeck.Money.Money;
import com.studnicki.tddBeck.Money.Sum;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertTrue(Money.dollar(10).equals(five.times(2)));
        assertTrue(Money.dollar(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
    }

    @Test
    public void testDifferentClassEquality(){
        assertEquals(new Money(10, "USD"), Money.dollar(10));
    }

    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);

        Expression sum = five.plus(Money.dollar(5));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);

        Sum sum = (Sum) result;

        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyOfDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){
        Bank bank = new Bank();
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);

        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(20), result);
    }
}
