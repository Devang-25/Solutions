package hackerearth.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AltF4AndSpinalNetwork {
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int link[] = new int[n];
			int deg[] = new int[n];
			for (int i = 1; i < n; i++) {
				int x = in.nextInt() - 1;
				int y = in.nextInt() - 1;
				deg[x]++;
				deg[y]++;
				link[x] = y;
				link[y] = x;
			}
			boolean isLeaf[] = new boolean[n];
			for(int i=0;i<n;i++) {
				if(deg[i] == 1) { 
					isLeaf[i] = true;
				}
			}
			for(int i=0;i<n;i++) {
				if(isLeaf[i]) {
					deg[link[i]]--;
					deg[i]--;
				}
			}
			boolean violation=false;
			for (int i = 0; i < n; i++) {
				if (deg[i] > 2) {
					System.out.println("NO");
					violation=true;
					break;
				}
			}
			if(!violation){
			System.out.println("YES");
			}
		}
		System.out.flush();
	}
}
