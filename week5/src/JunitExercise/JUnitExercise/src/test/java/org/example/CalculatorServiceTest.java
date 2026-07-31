package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorServiceTest {
    private final CalculatorService calculatorService=new CalculatorService();

    @Test
    public void testAdd(){
        int res=calculatorService.add(2,3);
        assertEquals(5,res);
    }

    //parameterized tests
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "10,20,30",
            "-5,5,0",
            "0,0,0"
    })
    public void testAdd_Parameterized(int a,int b,int expected){
        assertEquals(expected,calculatorService.add(a,b));
    }
}
