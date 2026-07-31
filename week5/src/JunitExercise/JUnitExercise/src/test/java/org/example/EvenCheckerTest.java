package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class EvenCheckerTest {
    //even nums
    @ParameterizedTest
    @ValueSource(ints={2,4,6,8,-16})
    public void testIsEven_WithEvenNumbers(int num1){
        EvenChecker checker=new EvenChecker();
        assertTrue(checker.isEven(num1));
    }

    //odd nums
    @ParameterizedTest
    @ValueSource(ints={3,5,99,67,-11})
    public void testIsEven_WithOddNumbers(int num2){
        EvenChecker checker=new EvenChecker();
        assertFalse(checker.isEven(num2));
    }
}
