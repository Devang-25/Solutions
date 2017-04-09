package hackerearth.examples;

//test trie thoroughly..
/* compressed trie one. */
public class Trie {
	int count = 1;//for the root node.

	class TrieNode {
		String suffix;
		TrieNode[] children = new TrieNode[26];
		boolean isLeaf = true;

		TrieNode(String suffix, boolean isLeaf) {
			System.out.println(suffix);
			this.suffix = suffix;
			this.isLeaf = isLeaf;
		}

		public void add(String s, int index) {
			System.out.println("adding " + s);
			TrieNode node = children[s.charAt(index) - 97];
			if (node == null) {
				String subS = s.substring(index);
				children[s.charAt(index) - 97] = new TrieNode(subS, true);
				count += subS.length();
			} else {
				if (node.suffix.equals(s.substring(index))) {
					return;
				}
				int min = Math.min(s.length(), node.suffix.length());
				int i = index + 1;
				for (; i < min; i++) {
					if (node.suffix.charAt(i) != s.charAt(i)) {
						System.out.println("splitting");
						// this is the point we split.
						String common = node.suffix.substring(index, i);
						System.out.println("common :" + common);
						String notCommon = node.suffix.substring(i);
						System.out.println("not common :" + notCommon);
						node.suffix = common;
						String subs = s.substring(i);
						System.out.println("subs :" + subs);
						node.children[subs.charAt(0) - 97] = new TrieNode(subs,
								true);
						count += subs.length();
						node.isLeaf = false;
						node.children[notCommon.charAt(0) - 97] = new TrieNode(
								notCommon, true);
						return;
					}
				}
				if (s.length() == min) {
					String common = node.suffix.substring(i,
							node.suffix.length());
					String notCommon = node.suffix.substring(i);
					System.out.println("notcommon :" + notCommon);
					node.suffix = common;
					node.children[notCommon.charAt(0) - 97] = new TrieNode(
							notCommon, true);
					node.isLeaf = false;
				} else {
					System.out.println("------------");
					node.add(s.substring(node.suffix.length()), 0);
				}

			}
		}
	}

	TrieNode root = new TrieNode(null, false);

	public void add(String s) {
		this.root.add(s, 0);
	}
}
