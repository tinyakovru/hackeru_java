package main;

import calculator.BestCalculator;
import calculator.Calculator;
import calculator.ICalc;
import factories.LoggerFactory;
import logger.ConsoleLogger;
import logger.FileLogger;
import logger.Loggable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Loggable logger = context.getBean(FileLogger.class);

        ICalc calculator = context.getBean(Calculator.class);
        calculator.sum(100,10);

        ICalc bcalc = context.getBean(BestCalculator.class);
        bcalc.diff(300,20)

//        logger.log("Hello");

    }












    /*public static void main(String[] args){
//        ConsoleLogger logger = new ConsoleLogger();

        Loggable logger = LoggerFactory.getLogget();
        Calculator calculator = new Calculator(logger);

        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        String command = "";
        int a = 0;
        int b = 0;

        while (flag){
            System.out.println("введите операцию \n Сумма: sum \n Разность: diff \n Умножение: nult \n Деление: div");
            command = sc.nextLine();
            System.out.println("введите первое число");
            a = sc.nextInt();

            System.out.println("введите второе число");
            b = sc.nextInt();

            switch (command){
                case "sum":
                    System.out.println(calculator.sum(a,b));
                    break;
                case "mult":
                    System.out.println(calculator.mult(a,b));
                    break;
                case "diff":
                    System.out.println(calculator.diff(a,b));
                    break;
                case "div":
                    System.out.println(calculator.div(a,b));
                    break;
                case "exit":
                    flag = false;
                    break;
                    default:
                        System.out.println("Такой команды нет");
            }
        }


    }*/
}
