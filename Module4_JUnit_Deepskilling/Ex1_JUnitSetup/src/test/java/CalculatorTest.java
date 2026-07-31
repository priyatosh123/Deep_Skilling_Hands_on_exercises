import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(10, calc.add(6, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, calc.subtract(8, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }
}
