package reflec.calculator;

public class Calculator {
    public int sum(int a, int b){
        return a+b;
    }

    public int diff(int a, int b){
        return a-b;
    }

    public int mult(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a/b;
    }
}
