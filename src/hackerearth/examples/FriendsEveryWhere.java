package hackerearth.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*incorrect answer*/
public class FriendsEveryWhere {
	public static void main(String[] args) {
		/* the intuition is that we use greedy approach.. */
		Scanner in = new Scanner(System.in);
		int friendsCount = in.nextInt() + 1;
		int friendships = in.nextInt();
		Friend friends[] = new Friend[friendsCount];
		for (int i = 0; i < friends.length; i++) {
			friends[i] = new Friend(i);
		}
		for (int i = 1; i <= friendships; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			friends[a].addFriend(friends[b]);
			friends[b].addFriend(friends[a]);
		}
		Friend popular = new Friend(-1);
		for (int i = 0; i < friends.length; i++) {
			if (friends[i].friends.size() > popular.friends.size()) {
				popular = friends[i];
			}
		}
		System.out.println(popular);
		System.out.println(popular.friends);
		for (Friend f : popular.getFriends()) {
			f.isFriend = true;
		}
		// popular.isFriend = true;
		// we start with the popular..
		int minToBeFriend = 1 + minToBefriend(popular);
		System.out.println(minToBeFriend);

	}

	private static int minToBefriend(Friend popular) {
		LinkedList<Friend> friends = new LinkedList<Friend>();
		friends.add(popular);
		int count = 0;
		while (!friends.isEmpty()) {
			Friend i = friends.remove();
			List<Friend> iFriends = i.getFriends();
			if (!i.isFriend) {
				count++;
				for (Friend iz : iFriends) {
					iz.isFriend = true;
				}
			} else {
				continue;
			}
			for (Friend iz : iFriends) {
				if (!iz.getFriends().isEmpty()) {
					System.out.println(iz);
					friends.addAll(iz.getFriends());
				}
			}
		}
		return count;
	}

	static class Friend {
		int id = -1;
		boolean isFriend = false;
		List<Friend> friends = new LinkedList<Friend>();

		Friend(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return this.id + " ";
		}

		public void addFriend(Friend f) {
			this.friends.add(f);
		}

		List<Friend> getFriends() {
			List<Friend> notFriends = new LinkedList<Friend>();
			for (Friend f : friends) {
				if (!f.isFriend) {
					notFriends.add(f);
				}
			}
			return notFriends;
		}
	}
}
