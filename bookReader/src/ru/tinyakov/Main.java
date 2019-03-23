package ru.tinyakov;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        File file = new File("book.txt");
        try {
            FileReader fr = new FileReader(file);
//            BufferedReader bufr = new BufferedReader(fr);

            System.out.println(file.length());
            long fsize_l = file.length();

            if(fsize_l > Integer.MAX_VALUE) throw new Exception("Too big size");
            int fsize = (int)fsize_l;

            char[] chs = new char[(int)fsize/2];
            int pageSize = (fsize >1800) ? 1800 : fsize;

            System.out.println(fr.read(chs,0,1800_000));
            int pageNum = 0;

//            bufr.read(chs,pageNum*pageSize, pageSize);

            for (int i = pageNum*1800; i <(pageNum+1)*1800 ; i++) {
                System.out.print(chs[i]);
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("\n============================\n1-страница назад, 3-страница вперед");
            while(true){
                int n = scan.nextInt();
                if(n == 1){
                    pageNum = (pageNum==0)? 0: --pageNum;
                }else if(n==3){

                }
            }
            /*while( (ch = (char)fr.read()) != -1){
                System.out.println(ch);
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
