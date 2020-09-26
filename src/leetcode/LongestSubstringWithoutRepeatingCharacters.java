package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] maxIndex = new int[256];
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, maxIndex[s.charAt(j)] + 1);
            max = Math.max(max, j - i + 1);
            maxIndex[s.charAt(j)] = j;
        }
        return max;
    }
}
