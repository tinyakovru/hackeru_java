public class Main {

    public static void main(String[] args) {
        long MAX = 40;
        for(double p = 2.0; p < MAX; p++) {
            //находим число мерсенна
            long mersenne = (long)Math.pow(2.0,p) - 1;
            // проверяем простое оно или нет
            if(checkSimple(mersenne)){
                // если простое, то оно нам подходит
                //вычисляем совершенное число по формуле
                long res = (long)Math.pow(2,p-1)*mersenne;
                System.out.println(res);
            }
        }
    }

    private static boolean checkSimple(long n){
        long sqrtn = (long)Math.sqrt(n);
        for(long i=2; i<=sqrtn; i++){
            long foo = n%i;
            if(foo == 0)return false;
        }
        return true;
    }
}
