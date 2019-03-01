import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<Person,PersonalData> hmap;
    static Person[] randPersons = new Person[100];

    public static void main(String[] args) {
        hmap = new HashMap<>();

        long tm1 = System.currentTimeMillis();

        generateData();
        System.out.println("generate done");

        getSomeValues();
        tm1 = System.currentTimeMillis()-tm1;
        System.out.println("time:"+tm1);
    }

    private static void getSomeValues(){
        for (Person p:randPersons) {
            PersonalData pd = hmap.get(p);
            System.out.println(pd.toString());
        }
    }

    private static void generateData(){
        int d = 1;
        int m = 1;
        int y = 1917;
        int count=0;
        String[] fname = {"вася","петя","зина","оля","галя","валя","саша","света","коля"};
        String[] lname = {"петров","васечкин","пупкин","иванов","сидоров","вицин","никулин","моргунов"};
        for(int i=0; i < 1_00_000; i++){
            String name = fname[(int)(Math.round(Math.random()*(fname.length-1)))];
            name += " " + lname[(int)(Math.round(Math.random()*(lname.length-1)))];;
            Person p = new Person(d,m,y,name);
            d++;
            if(d>30){
                d=1;
                m++;
                if(m>12){
                    m=1;
                    y++;
                }
            }
            int[] ar = {(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100)};
            PersonalData pd = new PersonalData(
                    (int)(Math.random()*100000),
                    (int)(Math.random()*100),
                    ar,"string",fname);
            hmap.put(p,pd);
            if(randPersons[99]==null && Math.random()<0.02 ){
                randPersons[count++] = p;
            }
        }

    }
}
