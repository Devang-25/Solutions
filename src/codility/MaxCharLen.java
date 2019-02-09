package codility;

import java.util.*;

public class MaxCharLen {

    public static void main(String[] args) {
        String len[] = new String[]{"abbba"};
        int solution = new MaxCharLen().solution(len);
        System.out.println(solution);
    }

    public int solution(String[] words) {
        HashMap<Character, TreeSet<LenPos>> start = new HashMap<>();
        HashMap<Character, TreeSet<LenPos>> end = new HashMap<>();
        Map<Character, Integer> all = new HashMap<>();
        int at = 0;
        for (String w : words) {
            char cStart = w.charAt(0);
            char[] charArray = w.toCharArray();

            int startLen = 1;
            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] == cStart) {
                    startLen++;
                } else {
                    break;
                }
            }

            int endLen = 1;
            char cEnd = w.charAt(w.toCharArray().length - 1);
            for (int i = charArray.length - 2; i >= 0; i--) {
                if (charArray[i] == cEnd) {
                    endLen++;
                } else {
                    break;
                }
            }


            if (endLen == startLen && cStart == cEnd && endLen == charArray.length) {
                all.putIfAbsent(cStart, 0);
                all.put(cStart, all.get(cStart) + endLen);
            } else {
                start.putIfAbsent(cStart, new TreeSet<>(new LenPos(0, 0)));
                TreeSet<LenPos> lenPos1 = start.get(cStart);
                lenPos1.add(new LenPos(startLen, at));
                start.put(cStart, lenPos1);

                end.putIfAbsent(cEnd, new TreeSet<>(new LenPos(0, 0)));
                TreeSet<LenPos> lenPos2 = end.get(cEnd);
                lenPos2.add(new LenPos(endLen, at));
                end.put(cEnd, lenPos2);
            }
            at++;
        }
        Integer max = getMax(start, end, all);
        max = Math.max(max, getMax(end, start, all));
        max = Math.max(max, all.values().stream().mapToInt(x -> x).max().orElse(0));

        return max;
    }

    private int getMax(HashMap<Character, TreeSet<LenPos>> start, HashMap<Character, TreeSet<LenPos>> end, Map<Character, Integer> all) {
        int max = Integer.MIN_VALUE;
        for (char c = 'a'; c <= 'z'; ++c) {
            if (end.get(c) != null) {
                LenPos first = end.get(c).first();
                Optional<LenPos> lenPos = start.getOrDefault(c, new TreeSet<>()).stream().filter(x -> x.pos != first.pos).findFirst();
                if (lenPos.isPresent()) {
                    max = Math.max(max, first.len + lenPos.get().len + all.getOrDefault(c, 0));
                } else {
                    max = Math.max(max, first.len + all.getOrDefault(c, 0));
                }
            }
        }
        return max;
    }

    static class LenPos implements Comparator<LenPos> {
        int len;
        int pos;

        public LenPos(int len, int pos) {
            this.len = len;
            this.pos = pos;
        }

        @Override
        public int compare(LenPos o1, LenPos o2) {
            if (o1.len < o2.len) {
                return 1;
            }
            return -1;
        }
    }
}
