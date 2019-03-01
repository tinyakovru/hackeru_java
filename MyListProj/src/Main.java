public class Main {

    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(14);

        System.out.println(  list.toString());
        //System.out.println(list.remove(7));
        list.reverse();
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
/*

        MyArray<String> strings = new MyArray<>(String.class);

        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");
        strings.add("11");
        strings.add("12");
        System.out.println(strings.toString());
*/

    }
}
