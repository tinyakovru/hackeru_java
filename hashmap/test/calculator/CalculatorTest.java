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
        int expect = 0;
        assertEquals(expect, calculator.diff(5,5));
    }

    @Ignore
    @Test
    public void multTest(){
        int expect = 10;
        assertEquals(expect,calculator.mult(5,2));
    }

    @Test
    public void divideTest(){
        int expect = 5;
        assertEquals(expect, calculator.divide(10,2));
    }

    @Test(expected = ArithmeticException.class)
    public void divideExceptionTest(){
        int expect = 10;
        assertEquals(expect, calculator.divide(5,0));
    }

    @Test(timeout = 100)
    public void divideTimeException(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void destroy(){
        calculator = null;
    }
}
