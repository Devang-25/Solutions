package hackerrank;

import java.util.Scanner;

public class GameOfThrones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int bitKeeper = 0;
        for (char c : s.toCharArray()) {
            if (((bitKeeper >> (c - 1)) & 1) == 1) {
                bitKeeper = bitKeeper & ~(1 << (c - 1));
            } else bitKeeper = 1 << c - 1 | bitKeeper;
        }
        if ((bitKeeper & (bitKeeper - 1)) == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
