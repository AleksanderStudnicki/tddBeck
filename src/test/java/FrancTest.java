import com.studnicki.tddBeck.Money.Dollar;
import com.studnicki.tddBeck.Money.Franc;
import com.studnicki.tddBeck.Money.Money;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrancTest {
    @Test
    public void testMultiplication(){
        Money five = Money.franc(5);
        assertTrue(new Franc(10).equals(five.times(2)));
        assertTrue(new Franc(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));

    }

}
