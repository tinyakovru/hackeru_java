import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<String> st = new Stack<>();
        st.push("str1");
        st.push("str2");
        st.push("str3");
        st.push("str4");

        System.out.println(st.toString());

        String str = st.peek();

        System.out.println(st.toString());
        System.out.println(str);

        str = st.pop();

        System.out.println(st.toString());
        System.out.println(str);

        Collection col;
        LinkedHashSet s;
        LinkedList d;

        System.out.println(str.compareTo("1"));

        Set<String> set = new HashSet<>();
        set.add("str1");
        set.add("str2");
        set.add("str3");
        set.add("str4");
        set.add("str5");

        for(String ss:set){
            System.out.println(ss);
        }
        System.out.println(set.toString());
    }
}
