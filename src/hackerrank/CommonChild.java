package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class CommonChild {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        System.out.println(maxCommonString(s1, s2));
    }

    private static int maxCommonString(String s1, String s2) {
        List<Character> s1Chars = toCharArray(s1);
        List<Character> s2Chars = toCharArray(s2);
        Set<Character> uniqS1Chars = new HashSet<>(s1Chars);
        Set<Character> uniqS2Chars = new HashSet<>(s2Chars);
        String commonS1 = s1Chars.stream().filter(uniqS2Chars::contains).map(j -> j + "").collect(Collectors.joining());
        String commonS2 = s2Chars.stream().filter(uniqS1Chars::contains).map(j -> j + "").collect(Collectors.joining());
        return lcs(commonS1.toCharArray(), commonS2.toCharArray());
    }


    static int lcs(char[] X, char[] Y) {
        int cache[][] = new int[X.length + 1][Y.length + 1];
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                if (i == 0 || j == 0)
                    cache[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                else
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
            }
        }
        return cache[X.length][Y.length];
    }

    private static List<Character> toCharArray(String s1) {
        List<Character> list = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            list.add(c);
        }
        return list;
    }


}
