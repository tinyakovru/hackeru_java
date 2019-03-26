package calculator;

import com.sun.javafx.image.impl.IntArgb;
import logger.Loggable;

public class BestCalculator implements ICalc {

    private Loggable logger;

    public BestCalculator(Loggable logger) {
        this.logger = logger;
    }

    public BestCalculator() {
    }

    public void setLogger(Loggable logger) {
        this.logger = logger;
    }

    @Override
    public int sum(int a, int b) {
        if(a> Integer.MAX_VALUE*0.5 || b>Integer.MAX_VALUE*0.5) throw new RuntimeException("error");
        int res = a + b;
        if(logger != null) logger.log(String.valueOf(res));
        return res;
    }

    @Override
    public int diff(int a, int b) {
        if(a==0 && b==0) throw new RuntimeException("error");
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
