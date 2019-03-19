package calculator;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorParametrizedTest {

    public static class CalculatorTest {
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

    @RunWith(Parameterized.class)
    public static class ParamPamPam{
        @Parameterized.Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][]{
                    {1,3,4},
                    {5,5,10},
                    {3,3,6}
            });
        }

        private int a;
        private int b;
        private int c;

        public ParamPamPam(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        Calculator calculator;

        @Before
        public void init(){
            calculator = new Calculator();
        }

        @Test
        public void sumParamTest(){
            Assert.assertEquals(c,calculator.sum(a,b));
        }
    }

}
