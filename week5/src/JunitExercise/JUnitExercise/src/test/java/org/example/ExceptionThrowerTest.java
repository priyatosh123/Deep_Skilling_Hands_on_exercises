package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    public void testThrowException_WhenValueIsNegative() {
        ExceptionThrower thrower = new ExceptionThrower();

        // assertThrows(ExpectedException.class, ExecutableLambda)
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> thrower.throwException(-1) // This code MUST throw the exception
        );

        // Optional: Verify the exact message inside the exception
        assertEquals("Negative values are not allowed!", exception.getMessage());
    }

    @Test
    public void testNoException_WhenValueIsPositive() {
        ExceptionThrower thrower = new ExceptionThrower();

        // assertDoesNotThrow checks that the lambda runs without crashing
        assertDoesNotThrow(() -> thrower.throwException(10));
    }
}