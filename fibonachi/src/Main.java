import java.math.BigInteger;

public class Main {
    public static long n1,n2,temp,N,count;
    public static void main(String[] args) {
        System.out.println(fibo(1000000));
    }

    public static long fibo(int N){
        int count = 3;
        long n1=n2=1;
        long temp;

        while(count<=N){
            temp = n2;
            n2 = n2+n1;
            n1 = temp;
            count++;
        }
        return n2;
    }
}
