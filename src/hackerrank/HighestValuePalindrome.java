package hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class HighestValuePalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String x = highestValuePalindrome(s, n, k);
        System.out.println(x != null ? x : -1);
    }

    static class State {
        char[] c;
        int i;
        int j;
        int changes;

        public State(char[] c, int i, int j, int changes) {
            this.c = c;
            this.i = i;
            this.j = j;
            this.changes = changes;
        }
    }

    private static Stack<State> stateStack = new Stack<>();

    static String highestValuePalindrome(String s, int n, int k) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        int changes = k;
        stateStack.push(new State(c, i, j, changes));
        return process();
    }

    private static String process() {
        while (!stateStack.isEmpty()) {
            State pop = stateStack.pop();
            int i = pop.i;
            int j = pop.j;
            char[] c = pop.c;
            int changes = pop.changes;
            if (i == j) {
                if (changes != 0) {
                    c[i] = '9';
                }
                return new String(c);
            }
            if (i + 1 == j) {
                if (c[i] == c[j]) {
                    if (changes >= 2) {
                        c[i] = c[j] = '9';
                    }
                    return new String(c);
                } else if (changes != 0) {
                    char t = c[i] > c[j] ? c[i] : c[j];
                    if (changes == 1) {
                        c[i] = t;
                        c[j] = t;
                    } else {
                        c[i] = c[j] = '9';
                    }
                    return new String(c);
                } else {
                    return null;
                }
            }
            if (c[i] != c[j]) {
                if (changes >= 2) {
                    char[] chars = new String(c).toCharArray();
                    char old = chars[i];
                    chars[i] = chars[j] = '9';
                    stateStack.push(new State(chars, i + 1, j - 1, old == '9' ? changes - 1 : changes - 2));
                }
                if (changes == 1 && c[j] < c[i]) {
                    char[] chars = new String(c).toCharArray();
                    chars[j] = chars[i];
                    stateStack.push(new State(chars, i + 1, j - 1, changes - 1));
                }
            } else if (changes >= 2) {
                char[] chars = new String(c).toCharArray();
                char old = chars[i];
                chars[i] = chars[j] = '9';
                stateStack.push(new State(chars, i + 1, j - 1, old == '9' ? changes : changes - 2));
                continue;
            } else {
                stateStack.push(new State(c, i + 1, j - 1, changes));
            }
        }
        return null;
    }
}
