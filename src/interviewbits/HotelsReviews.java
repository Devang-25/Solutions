package interviewbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsReviews {
    public static void main(String args[]) {
        List<String> words = new ArrayList<>();
        words.add("cool");
        words.add("ice");
        words.add("wifi");
        ArrayList<Integer> solve = solve("play_boy", Arrays.asList("smart_play", "girl_and_boy_play", "play_ground"));
        System.out.println(solve);

    }

    public static ArrayList<Integer> solve(String A, List<String> B) {
        String words[] = A.split("_");
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        ArrayList<Review> reviews = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            reviews.add(new Review(i));
        }
        for (int i = 0; i < B.size(); i++) {
            String review = B.get(i);
            String w[] = review.split("_");
            for (String s : w) {
                if (trie.search(s)) {
                    reviews.get(i).score++;
                }
            }
        }
        Collections.sort(reviews, (x, y) -> {
            if (x.score > y.score) {
                return -1;
            }
            if (x.score == y.score) {
                return 0;
            }
            return 1;
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (Review r : reviews) {
            list.add(r.index);
        }
        return list;
    }

    static class Review {
        int index;
        int score;

        Review(int index) {
            this.index = index;
        }
    }


    static class Trie {

        static final int SIZE = 26;

        class TrieNode {
            TrieNode[] children = new TrieNode[SIZE];
            boolean isLeaf;

            TrieNode() {
                for (int i = 0; i < SIZE; i++)
                    children[i] = null;
                isLeaf = false;
            }
        }

        TrieNode root = new TrieNode();

        void insert(String key) {
            int length = key.length();
            int index;
            TrieNode nodeAt = root;
            for (int l = 0; l < length; l++) {
                index = key.charAt(l) - 'a';
                if (nodeAt.children[index] == null)
                    nodeAt.children[index] = new TrieNode();

                nodeAt = nodeAt.children[index];
            }
            nodeAt.isLeaf = true;
        }

        boolean search(String key) {
            int length = key.length();
            int index;
            TrieNode nodeAt = root;

            for (int level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';

                if (nodeAt.children[index] == null)
                    return false;

                nodeAt = nodeAt.children[index];
            }

            return (nodeAt != null && nodeAt.isLeaf);
        }
    }

}
