package tests;

import annotations.AfterSuit;
import annotations.BeforSuit;
import annotations.Test;
import testManager.AbstractTest;

public class CalculatorTest extends AbstractTest {

    Calculator calc;


    @BeforSuit
    void befor(){
        try {
            calc = (Calculator)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Metod BeforSuit run");
    }

    @AfterSuit
    void after(){
        System.out.println("Metod AfterSuit run");
    }

    @Test
    void test0(){
        System.out.println("test 0 run");
    }

    @Test(prior = 1)
    void test1(){
        System.out.println("test 1 run");
    }

    @Test(prior = 10)
    void test2(){
        System.out.println("test 2 run");
    }
    @Test(prior = 3)
    void test3(){
        System.out.println("test 3 run");
    }

    @Test()
    void test4(){
        System.out.println("test 4 run");
    }

    @Test(prior = 1)
    void test5(){
        System.out.println("test 5 run");
    }
    @Test(prior = 8)
    void test6(){
        System.out.println("test 6 run");
    }
    @Test(prior = 8)
    void test7(){
        System.out.println("test 7 run");
    }



}
