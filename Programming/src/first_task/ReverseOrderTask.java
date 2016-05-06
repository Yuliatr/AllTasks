package first_task;

import java.util.*;

public class ReverseOrderTask {
    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<String>(
                new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        StringBuilder sb1 = new StringBuilder(s1);
                        StringBuilder sb2 = new StringBuilder(s2);
                        return sb1.reverse().toString().compareTo(sb2.reverse().toString());
                    }
                }
        );

        set.addAll(Arrays.asList(args));
        //       String[] str = {"a", "b", "c", "12a", "1a", "cba"};           <------- работаееет все окей
        //       set.addAll(Arrays.asList(str));
        if (!set.isEmpty())
            System.out.println(set);
        else
            System.out.println("EMPTY!");
    }
}
