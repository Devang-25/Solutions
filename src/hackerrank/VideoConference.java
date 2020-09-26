package hackerrank;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VideoConference {
    public static class Trie {

        // Alphabet size (# of symbols)
        static final int ALPHABET_SIZE = 26;

        // trie node
        class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];

            // isEndOfWord is true if the node represents
            // end of a word
            int isEndOfWord = -1;

            TrieNode() {
                isEndOfWord++;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }

        private TrieNode root = new TrieNode();

        // If not present, inserts key into trie
        // If the key is prefix of trie node,
        // just marks leaf node
        void insert(String key) {
            int level;
            int length = key.length();
            int index;

            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
            }

            // mark last node as leaf
            pCrawl.isEndOfWord++;
        }

        // Returns true if key presents in trie, else false
        LevelOrEnd search(String key) {
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';

                if (pCrawl.children[index] == null) {
                    insert(key);
                    return new LevelOrEnd(level, 0);
                }
                pCrawl = pCrawl.children[index];
            }
            pCrawl.isEndOfWord++;
            return new LevelOrEnd(level, pCrawl.isEndOfWord);
        }
    }

    static class LevelOrEnd {
        int level;
        int end;

        public LevelOrEnd(int level, int end) {
            this.level = level;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();

        Trie trie = new Trie();
        IntStream.range(0, len).forEach(i -> {
            String name = in.next();
            LevelOrEnd search = trie.search(name);
            if (search.end != 0) {
                System.out.println(name + " " + search.end);
            } else {
                System.out.println(name.substring(0, search.level + 1));
            }
        });
    }


    public static List<String> solve(List<String> names) {
        Trie trie = new Trie();
        return names.stream().map(n -> {
            LevelOrEnd search = trie.search(n);
            if (search.end != 0) {
                return n + " " + search.end;
            } else {
                return n.substring(0, search.level + 1);
            }
        }).collect(Collectors.toList());
    }

}
