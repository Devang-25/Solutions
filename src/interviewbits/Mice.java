package interviewbits;

import java.util.ArrayList;
import java.util.Collections;

public class Mice {

    public static void main(String[] args) {

    }

    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            integers.add(Math.abs(a.get(i) - b.get(i)));
        }
        return integers.stream().mapToInt(x -> x).max().getAsInt();
    }
}
