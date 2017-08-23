package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by gurpreet.makkar on 11/06/17.
 */
public class Abbreviations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String a = in.next();
            String b = in.next();
            boolean result = evaluate(a, b);
            System.out.println(result ? "YES" : "NO");
        }
    }


    private static HashMap<String, Boolean> cache = new HashMap<>();

    private static boolean evaluate(String a, String b) {
        cache = new HashMap<>();
        //handle case of a caps in A and not in B
        boolean bMap[] = new boolean[26];
        for (char c : b.toCharArray()) {
            bMap[c - 65] = true;
        }
        for (char c : a.toCharArray()) {
            if (Character.isUpperCase(c) && !bMap[c - 65]) {
                return false;
            }
        }
        return eval(a, b);
    }

    private static boolean eval(String a, String b) {
        System.out.println("eval(" + a + "," + b + ")");
        if (b.isEmpty()) {
            return a.toLowerCase().equals(a);
        }
        if (a.isEmpty()) {
            return false;
        }
        if (a.length() == 1 && b.length() == 1 && Character.isUpperCase(a.charAt(0)) && Character.isUpperCase(b.charAt(0)) && a.charAt(0) != b.charAt(0)) {
            return false;
        }
        String newA = a.substring(0, a.length() - 1);
        String newB = b.substring(0, b.length() - 1);
        String key = newA + "|" + newB;
        if (cache.containsKey(key)) {
            System.out.println("Hit cache");
            return cache.get(key);
        }
        char last = a.charAt(a.length() - 1);
        if (Character.isLowerCase(last)) {
            if (!caseInsensitiveLastCharsMatch(a, b)) {
                boolean result = eval(newA, b);
                if (result)
                    cache.put(newA + "|" + b, result);
                return result;
            } else {
                boolean resultA = eval(newA, newB);
                if (resultA)
                    cache.put(newA + "|" + newB, resultA);
                boolean resultB = eval(newA, b);
                if (resultB)
                    cache.put(newA + "|" + b, resultB);
                return resultA || resultB;
            }
        } else if (caseInsensitiveLastCharsMatch(a, b)) {
            boolean result = eval(newA, newB);
            cache.put(key, result);
            return result;
        }
        return false;

    }

    private static boolean caseInsensitiveLastCharsMatch(String a, String b) {
        char last = a.charAt(a.length() - 1);
        return String.valueOf(last).toUpperCase().equals(String.valueOf(b.charAt(b.length() - 1)));
    }
}
