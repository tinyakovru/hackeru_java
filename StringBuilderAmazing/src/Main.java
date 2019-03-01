public class Main {

    public static void main(String[] args) {
        //генерируем массив со строками
        int count = 1_000_000;
        String[] ar = new String[count];
        String str;
        for(int i=0; i<count; i++){
            int lengthStr = (int)(Math.random()*12+3);
            str = "";
            for(int j=0; j<lengthStr; j++)
                str += Character.toString((int)(Math.random()*26+65));
            ar[i] = str;
        }

        count = 100_000;

        long tm1 = System.currentTimeMillis();
        String str1 = "";
        for(int i =0; i<count;i++){
            int indx = (int)(Math.random()*1000000);
            str1 += ar[indx];
        }
        System.out.println(str1);
        System.out.println("time ="+(System.currentTimeMillis()-tm1)); // 6332 , 6160

        long tm2 = System.currentTimeMillis();
        StringBuilder str2 = new StringBuilder();
        for(int i =0; i<count;i++){
            int indx = (int)(Math.random()*1000000);
            str2.append(ar[indx]);
        }
        System.out.println(str2.toString());
        System.out.println("time ="+(System.currentTimeMillis()-tm2)); // 48 , 44
    }
}
