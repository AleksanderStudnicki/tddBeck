import com.studnicki.tddBeck.Money.Dollar;
import com.studnicki.tddBeck.Money.Franc;
import com.studnicki.tddBeck.Money.Money;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrancTest {
    @Test
    public void testMultiplication(){
        Money five = Money.franc(5);
        assertTrue(Money.franc(10).equals(five.times(2)));
        assertTrue(Money.franc(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testDifferentClassEquality(){
        assertEquals(new Money(10, "CHF"), Money.franc(10));
    }
}
