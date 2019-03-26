package calculator;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    static Calculator calculator;

    @BeforeClass
    public static void init(){
        calculator = new Calculator();
    }

    @Test
    public void sumTest(){
        int expect = 10;
        assertEquals(expect, calculator.sum(5,5));
    }

    @Test
    public void diffTest(){
        int expect = 11;
        assertEquals(expect, calculator.diff(55,44));
    }


    public void multTest(){

    }

    public void divideTest(){}

    @Test(expected = ArithmeticException.class)
    public void divideExeptionTest(){
        int expected = 10;
        assertEquals(expected, calculator.divide(100,0));
    }

    @Test
    public void divideTimeException(){

    }

    @AfterClass
    public static void destroy(){
        calculator = null;
    }

}
