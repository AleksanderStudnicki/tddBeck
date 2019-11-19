import com.studnicki.tddBeck.Money.Dollar;
import com.studnicki.tddBeck.Money.Franc;
import com.studnicki.tddBeck.Money.Money;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DollarTest {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertTrue(Money.dollar(10).equals(five.times(2)));
        assertTrue(Money.dollar(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }
}
