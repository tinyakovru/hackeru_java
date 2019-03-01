import java.lang.reflect.Array;

public class MyArray<T> {

    private T[] ar;
    private int size;
    private Class<T> TClass;

    private float k = 1.6f;
    private int coursor = 0;

    public MyArray(Class<T> tclass) {
        TClass = tclass;
        size = 10;
        ar = (T[])Array.newInstance(TClass,size);
    }

    public boolean add(T value){
        if(size<=coursor){
            resizeArray();
        }
        ar[coursor++] = value;
        return true;
    }

    public String toString(){
        StringBuilder strb = new StringBuilder("");
        for(T val : ar) {
            if(val!=null) {
                strb.append(val+",");
            }else
                break;
        }
        strb.deleteCharAt(strb.length()-1);
        return strb.toString();
    }

    private void resizeArray(){
        size = (int)(size*k);
        T[] ar2 = (T[])Array.newInstance(TClass,size);
        for(int i=0; i<ar.length; i++){
            ar2[i] = ar[i];
        }
        ar = ar2;
    }




}

