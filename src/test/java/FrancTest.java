import com.studnicki.tddBeck.Money.Franc;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrancTest {
    @Test
    public void testMultiplication(){
        Franc five = new Franc(5);
        assertTrue(new Franc(10).equals(five.times(2)));
        assertTrue(new Franc(15).equals(five.times(3)));
    }

    @Test
    public void testEquality(){
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
    }

}
