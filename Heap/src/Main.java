public class Main {

    public static void main(String[] args) {
        int[] array = {1,34,12,87,21,2,7,9,16,23,34,45,56,54,43,32,21};
        for(int i : array)
            System.out.print(i+" ");
        System.out.println(" ");
        MyHeap heap = new MyHeap();
       /* heap.add(9);
        heap.add(13);
        heap.add(3);
        heap.add(7);
        heap.add(17);
        heap.add(21);*/

        heap.arraySort(array);
        for(int i : array)
            System.out.print(i+" ");


    }
}
