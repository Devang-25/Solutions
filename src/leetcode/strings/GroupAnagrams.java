package leetcode.strings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        final List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            final char[] c = str.toCharArray();
            Arrays.sort(c);
            final String sorted = new String(c);
            anagramMap.putIfAbsent(sorted, new ArrayList<>());
            anagramMap.get(sorted).add(str);
        }
        System.out.println(anagramMap);
        return new ArrayList<>(anagramMap.values());
    }

}
