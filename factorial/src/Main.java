public class Main {

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("factorial %d = %d",n,factorial(n));
    }

    private static long factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
