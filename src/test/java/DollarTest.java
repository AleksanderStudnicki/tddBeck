import com.studnicki.tddBeck.Money.Dollar;
import com.studnicki.tddBeck.Money.Franc;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DollarTest {
    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        assertTrue(new Dollar(10).equals(five.times(2)));
        assertTrue(new Dollar(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertFalse(new Dollar(5).equals(new Franc(5)));
    }
}
