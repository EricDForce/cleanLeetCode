import java.util.*;

/**
 * Created by eric-d on 2017/1/19.
 */
public class list_test {
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<String> setstr = new HashSet<>();
        setstr.add("dengli");
        setstr.add("abcdeng");
        setstr.add("gdffsf");
        setstr.add("efgtrrtr");
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(4);
        set.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(4);

        for (String str : setstr) {
            System.out.println(str);
        }
        for (int i : set) {
            System.out.println("i: " + i);
        }
        for (int i : list) {
            System.out.println("i : " + i);
        }
    }
}
