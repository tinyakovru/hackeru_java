import java.util.ArrayList;

public class MyHeap {

    private ArrayList<Integer> list;
    public MyHeap(){
        list = new ArrayList();
    }

    public void add(int val){
        list.add(val);
        int i = heapSize()-1;
        int parent = (int)( (i-1)/2 );
        while (i>0 && list.get(i) > list.get(parent)){
            int temp = list.get(i);
            list.set(i,list.get(parent));
            list.set(parent,temp);
            i = parent;
            parent = (int)( (i-1)/2 );
        }
    }

    public void sortHeap(int i){
        int left;
        int right;
        int max;

        for(;;){
            left = 2*i + 1;
            right = 2*i + 2;
            max = i;

            if(left < heapSize() && list.get(left) > list.get(max)){
                max = left;
            }
            if(right < heapSize() && list.get(right) > list.get(max)){
                max = right;
            }
            if(max==i){
                break;
            }

            int temp = list.get(i);
            list.set(i,list.get(max));
            list.set(max,temp);

            i = max;
        }
    }

    public int getMaxNum(){
        int res = getMax();
        sortHeap(0);
        return res;
    }

    private int getMax(){
        int res = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        return res;
    }

    public void buildHeap(int[] array){
        for(int v:array){
            list.add(v);
        }
        for (int i = heapSize() / 2; i >= 0; i--)
        {
            sortHeap(i);
        }
    }

    public void arraySort(int[] ar){
        buildHeap(ar);

        for(int i=ar.length-1; i>=0; i--){
            ar[i] = getMaxNum();
        }
    }

    private int heapSize(){
        return list.size();
    }
}
