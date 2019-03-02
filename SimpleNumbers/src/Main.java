import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Введите число больше 2:");

            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num < 2) throw new Exception("Invalid param");

            ArrayList s = getAllSimple(num);
            printNums(s);
            scanner.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static ArrayList getAllSimple(int num){
        boolean[] markers = new boolean[num+1];

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=2; i<=num; i++){
            if(!markers[i]){
                result.add(i);
            }
            for(int k=2; k<=i; k++){
                int foo = k*i;
                if (foo>num) break;
                markers[foo] = true;
            }
        }
        return result;
    }

    private static void printNums(ArrayList<Integer> ar){
        for(int n : ar){
            System.out.print(n+",  ");
        }
    }
}
