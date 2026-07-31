package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
    @Test
    public void testCalculatorMethods(){
        //equals
        Calculator calc=new Calculator();
        assertEquals(5,calc.add(2,3));

        //truecondition
        assertTrue(calc.isPositive(10));

        //falsecondition
        assertFalse(calc.isPositive(-5));

        //null
        assertNull(calc.getGreeting(null));

        //notnull
        assertNotNull(calc.getGreeting("Ananya"));
    }
}
