package geek.examples;

import java.util.Arrays;

public class ReverseDNSLookupCache {
	// A utility function to find index of child for a given character 'c'
	public static int getIndex(char c) {
		return (c == '.') ? 10 : (c - '0');
	}

	// A utility function to find character for a given child index.
	char[] getCharFromIndex(int i) {
		//return (i == 10) ? '.' : ('0' + i);
		return new char[]{};
	}

	// Trie Node.
	static class TrieNode {
		boolean isLeaf;
		char[] URL;
		TrieNode child[] = new TrieNode[11];
	};

	// Function to create a new trie node.
	static TrieNode newTrieNode() {
		TrieNode newNode = new TrieNode();
		newNode.isLeaf = false;
		newNode.URL = null;
		for (int i = 0; i < 11; i++)
			newNode.child[i] = null;
		return newNode;
	}

	// This method inserts an ip address and the corresponding
	// domain name in the trie. The last node in Trie contains the URL.
	static void insert(TrieNode root, char[] ipAdd, char[] URL) {
		// Length of the ip address
		int len = ipAdd.length;
		TrieNode pCrawl = root;

		// Traversing over the length of the ip address.
		for (int level = 0; level < len; level++) {
			// Get index of child node from current character
			// in ipAdd[]. Index must be from 0 to 10 where
			// 0 to 9 is used for digits and 10 for dot
			int index = getIndex(ipAdd[level]);

			// Create a new child if not exist already
			if (pCrawl.child[index] == null)
				pCrawl.child[index] = newTrieNode();

			// Move to the child
			pCrawl = pCrawl.child[index];
		}

		// Below needs to be carried out for the last node.
		// Save the corresponding URL of the ip address in the
		// last node of trie.
		pCrawl.isLeaf = true;
		pCrawl.URL = Arrays.copyOf(URL, URL.length);
	}

	// This function returns URL if given IP address is present in DNS cache.
	// Else returns NULL
	static char[] searchDNSCache(TrieNode root, char[] ipAdd) {
		// Root node of trie.
		TrieNode pCrawl = root;
		int len = ipAdd.length;

		// Traversal over the length of ip address.
		for (int level = 0; level < len; level++) {
			int index = getIndex(ipAdd[level]);
			if (pCrawl.child[index] == null)
				return null;
			pCrawl = pCrawl.child[index];
		}

		// If we find the last node for a given ip address, print the URL.
		if (pCrawl != null && pCrawl.isLeaf)
			return pCrawl.URL;

		return null;
	}

	// Driver function.
	public static void main(String args[]) {
		/* Change third ipAddress for validation */
		String ipAdd[] = { "107.108.11.123", "107.109.123.255",
				"74.125.200.106" };
		String URL[] = { "www.samsung.com", "www.samsung.net", "www.google.in" };
		TrieNode root = newTrieNode();

		// Inserts all the ip address and their corresponding
		// domain name after ip address validation.
		for (int i = 0; i < ipAdd.length; i++)
			insert(root, ipAdd[i].toCharArray(), URL[i].toCharArray());

		// If reverse DNS look up succeeds print the domain
		// name along with DNS resolved.
		char ip[] = "107.108.11.123".toCharArray();
		char[] res_url = searchDNSCache(root, ip);
		if (res_url != null)
			System.out
					.println("Reverse DNS look up resolved in cache:\n%s --> %s"
							+ ip + ":" + res_url);
		else
			System.out.println("Reverse DNS look up not resolved in cache ");
	}
	// Output:
	//
	// Reverse DNS look up resolved in cache:
	// 107.108.11.123 --> www.samsung.com
}
