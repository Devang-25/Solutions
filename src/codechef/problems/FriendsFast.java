package codechef.problems;

import java.util.Scanner;

public class FriendsFast {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int noOfFriends = in.nextInt();
		char isFriend[][] = new char[noOfFriends][noOfFriends];
		for (int i = 0; i < noOfFriends; i++) {
			String row = in.next();
			isFriend[i] = row.toCharArray();
		}
		int nonFriends[] = new int[noOfFriends];
		int friends[] = new int[noOfFriends];
		int suggestions = 0;
		for (int X = 0; X < noOfFriends; X++) {
			int a = 0;
			int b = 0;
			for (int Y = 0; Y < noOfFriends; Y++) {
				if (X != Y) {
					if (isFriend[X][Y] == '0')
						nonFriends[b++] = Y;
					else
						friends[a++] = Y;
				}
			}

			for (int j = 0; j < b; j++)
				for (int k = 0; k < a; k++)
					if (isFriend[friends[k]][nonFriends[j]] == '1') {
						//if a friend of X has a friend that is not a friend of X. 
						suggestions++;
						break;
					}

		}

		System.out.println(suggestions);

	}
}