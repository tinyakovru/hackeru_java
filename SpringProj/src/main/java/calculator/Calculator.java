package calculator;


import logger.ConsoleLogger;
import logger.FileLogger;
import logger.Loggable;

import java.util.logging.Logger;

public class Calculator implements ICalc {
//    private ConsoleLogger logger;

    private Loggable logger;

    public void setLogger(Loggable logger) {
        this.logger = logger;
    }

    public Calculator() {
    }

    /*public Calculator(Loggable logger) {
        this.logger = logger;
    }*/
//    public Calculator(ConsoleLogger logger) {
//        this.logger = logger;
//    }
    @Override
    public int sum(int a, int b) {
        int res = a+b;
        if(logger != null) logger.log(String.valueOf(res));
        return res;
    }
    @Override
    public int diff(int a, int b) {
        int res = a - b;
        if(logger != null) logger.log(String.valueOf(res));
        return res;
    }
    @Override
    public int mult(int a, int b) {
        int res = a * b;
        if(logger != null) logger.log(String.valueOf(res));
        return res;
    }
    @Override
    public int div(int a, int b) {
        if (b == 0) throw new ArithmeticException("divide by zero");
        int res = a / b;
        if(logger != null) logger.log(String.valueOf(res));
        return res;
    }

}
