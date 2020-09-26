package leetcode;

public class CompareVersionNumbers {


    public static void main(String[] args) {
        final int r = new CompareVersionNumbers().compareVersion("1.0.11.0", "1.00.1.0");
        System.out.println(r);
    }

    public int compareVersion(String version1, String version2) {
        return new Version(version1).compareTo(new Version(version2));
    }

    static class Version implements Comparable<Version> {
        String version;

        public Version(String version) {
            this.version = version;
        }

        @Override
        public int compareTo(Version o) {
            final String[] sequence1 = version.split("\\.");
            final String[] sequence2 = o.version.split("\\.");
            int len = Math.max(sequence1.length, sequence2.length);
            for (int i = 0; i < len; i++) {
                int x = s(sequence1, i);
                int y = s(sequence2, i);
                if (x < y) {
                    return -1;
                } else if (x > y) {
                    return 1;
                }
            }
            return 0;
        }

        private int s(String[] sequence, int i) {
            if (i >= sequence.length) {
                return 0;
            }
            return Integer.parseInt(sequence[i]);
        }
    }
}
