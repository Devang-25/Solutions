package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        final boolean b = new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak_(s, new HashSet<>(wordDict), new HashSet<>());
    }

    private boolean wordBreak_(String s, HashSet<String> wordDict, HashSet<String> wordCache) {
        if (s.equals("")) {
            return true;
        }
        if (wordCache.contains(s)) {
            return true;
        }
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String w = s.substring(0, i + 1);
            if (wordDict.contains(w)) {
                if (wordBreak_(s.substring(i + 1), wordDict, wordCache)) {
                    wordCache.add(s.substring(i + 1));
                    return true;
                }
            }
        }
        return false;
    }
}
