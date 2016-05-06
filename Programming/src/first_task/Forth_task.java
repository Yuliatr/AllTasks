package first_task;


import java.util.Arrays;
import java.util.TreeSet;

public class Forth_task {
    public static void main(String[] args) {

        //int chislo=Integer.parseInt(str);

        TreeSet<String> ts = new TreeSet<String>();
        ts.addAll(Arrays.asList(args));

        TreeSet<Integer> tsComp = new TreeSet<Integer>();
        TreeSet<Integer> tsNonComp = new TreeSet<Integer>();

        for (String s: ts) {
            int num = Integer.parseInt(s);

        }

    }
}


/*
        boolean isComposite = false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isComposite = true;
                break;
            }
        }
*/