package org.example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdvancedCalculatorTest {
    private Calculator calculator;

    //setup method
    //runs before @test method

    @Before
    public void setUp(){
        //arrange
        calculator=new Calculator();
        System.out.println("Fresh Calcualtor instance");
    }

    //runs after each test method
    @After
    public void tearDown(){
        calculator=null;
        System.out.println("Cleaned up calc instance");
    }

    //use aaa pattern
    @Test
    public void testAddition_PositiveNumbers(){

        //arrange
        int n1=20;
        int n2=24;

        //act
        int actualres= calculator.add(n1,n2);

        //assert
        assertEquals(44,actualres);
    }
    @Test
    public void testIsPositive_NegativeNumber(){
        //arrange
        int a=-123;

        //act
        boolean res= calculator.isPositive(a);

        //assert
        assertFalse(res);
    }
}
