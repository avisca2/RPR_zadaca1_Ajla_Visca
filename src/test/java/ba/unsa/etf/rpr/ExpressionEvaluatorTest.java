package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.ExpressionEvaluator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @Test
    void testIspravneVrijednost() throws Exception {
        assertEquals(101, evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )").doubleValue());
    }

    @Test
    void testPogresneVrijednosti() throws Exception {
        assertNotEquals(100, evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )").doubleValue());
    }

    @Test
    void testNegativneVrijednosti() throws Exception {
        assertNotEquals(-100, evaluator.evaluate("( 1 - ( ( 2 + 3 ) * ( 4 * 5 ) ) )").doubleValue());
    }

    void testDecimala() throws Exception {
        assertNotEquals(0.01, evaluator.evaluate("( 1 / ( ( 2 + 3 ) * ( 4 * 5 ) ) )").doubleValue());
    }

    @Test
    void nevalidanIzraz1() throws Exception {
        assertThrows(RuntimeException.class, () -> {  evaluator.evaluate("(1+((2+3)*(4*5)))").doubleValue();  } );
    }

    @Test
    void nevalidanIzraz2() throws Exception {
        assertThrows(RuntimeException.class, () -> {  evaluator.evaluate("").doubleValue();  } );
    }

    @Test
    void nevalidanIzraz3() throws Exception {
        assertThrows(RuntimeException.class, () -> {  evaluator.evaluate("dsafsafsafsafsafsfa").doubleValue();  } );
    }

}