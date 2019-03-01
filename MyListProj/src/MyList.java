public class MyList<T>  {

    private class MyNode<T>{
        private T val;
        private MyNode next;


        public MyNode(T val) {
            this.val = val;
        }
    }

    private MyNode head;
    private int size =0;

    public void add(T o){
        MyNode val = new MyNode(o);
        if(head == null){
            head = val;
        }else{
            MyNode<T> last = getLast();
            last.next = val;
        }
        size ++;
    }

    // добавить reverse remove
    public boolean remove(T val){
        MyNode prev = head;
        if(prev.val.equals(val)){
            head = prev.next;
            size--;
            return true;

        }else{
            while(prev.next!=null){
                MyNode cur = prev.next;
                if(cur.val.equals(val)){
                    prev.next = cur.next;
                    size--;
                    return true;
                }else{
                    prev = cur;
                }
            }
            return false;
        }
    }

    public void reverse(){
        MyNode[] links = new MyNode[size-1];
        MyNode node = head;
        int count =0;
        //пробегаем по списку и сохраняем ссылки на следующий элемент в массив
        while(node.next != null) {
            links[count++] = node.next;
            node = node.next;
        }
        // опять пробегаем по списку и и переписываем ссылки на следующий элемент из массива со смещением 2
        // первые два элемента обрабатываем специальным образом
        // последний элемент становится головой списка
        node = head;
        count = -2;
        while (node.next != null) {
            MyNode nextNode = node.next;
            if(count==-2) {
                node.next = null;
            }else if(count==-1){
                node.next=head;
            }else{
                node.next = links[count];
            }
            count++;

            node = nextNode;
        }
        head = node;
        head.next = links[count];
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        MyNode<T> first = head;
        if(first != null){
            str.append(first.val);
            while (first.next != null) {
                first = first.next;
                str.append(",");
                str.append(first.val);
            }
        }
        return str.toString();
    }

    private MyNode getLast(){
        MyNode n = head;
        while (n.next != null){
            n = n.next;
        }
        return n;
    }
}
