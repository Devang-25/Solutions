package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MobileConversations {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int N = in.nextInt();
		ArrayList<Call> cList = new ArrayList<>(N);
		for (int i = 1; i <= N; i++) {
			cList.add(new Call(in.nextInt(), in.nextInt()));
		}
		Collections.sort(cList, new Call());
		System.out.println(cList);
		int minRequired = cList.get(0).talkTime;
		int balance = cList.get(0).recharge;
		for (int i = 1; i < cList.size(); i++) {
			Call c = cList.get(i);
			if (c.talkTime > balance) {
				minRequired += (c.talkTime - balance);
				balance += c.recharge;
			} else {
				balance -= c.talkTime;
			}
		}
		System.out.println(minRequired);
	}

	static class Call implements Comparator<Call> {
		private int talkTime, recharge;

		Call() {

		}

		Call(int T, int X) {
			this.talkTime = T;
			this.recharge = X;
		}

		@Override
		public int compare(Call c1, Call c2) {
		 double a=(double)c1.recharge/c1.talkTime;
		 double b=(double)c2.recharge/c2.talkTime;
			if(a<=b){
				return 1;
			}
			return -1;
		}
		@Override
		public String toString() {
			return this.talkTime+"-"+this.recharge;
		}
		

	}
}
