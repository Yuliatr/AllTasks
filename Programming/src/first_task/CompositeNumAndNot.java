package first_task;
import java.util.ArrayList;
import java.util.TreeSet;

public class CompositeNumAndNot {
    public static void main(String[] args) {
        TreeSet<Integer> trComp = new TreeSet<Integer>();
        TreeSet<Integer> trNotComp = new TreeSet<Integer>();

        for (String s : args) {
            Integer num = Integer.parseInt(s);
            if (isComposite(num))
                trComp.add(num);
            else trNotComp.add(num);
        }

        ArrayList<Integer> list = new ArrayList<Integer>(trComp);
        for (Integer i:trNotComp) {
            list.add(i);
        }
        System.out.println(list);
    }

    public static boolean isComposite(int num) {
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}