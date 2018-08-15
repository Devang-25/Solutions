package hackerearth.examples;

import java.util.*;

public class GridlandMetro {
    static Map<Integer, TreeSet<Track>> map = new HashMap<>(1000);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        for (int i = 0; i < k; i++) {
            int row = in.nextInt();
            map.putIfAbsent(row, new TreeSet<>());
            Track givenTrack = new Track(in.nextInt(), in.nextInt());
            Track track = givenTrack;
            TreeSet<Track> tracksInRow = map.get(row);
            if (tracksInRow.isEmpty()) {
                tracksInRow.add(track);
                continue;
            }
            while (track != null) {
                Track ntrack = effectiveTrack(track, tracksInRow.first());
                if (ntrack == null) {
                    tracksInRow.add(track);
                } else {
                    tracksInRow.pollFirst();
                    tracksInRow.add(ntrack);
                }
                track = ntrack;
            }
        }
        long sum = (long) n * m - map.values().stream().flatMap(x -> x.stream()).mapToLong(t -> t.end - t.start + 1).sum();
        System.out.println(sum);
        in.close();

    }

    private static class Track implements Comparable<Track> {

        int start;
        int end;

        public Track(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Track o2) {
            if (this.start == o2.start && this.end == o2.end) {
                return 0;
            }
            if (this.start < o2.start) {
                return -1;
            }
            return 1;
        }
    }

    private static Track effectiveTrack(Track t1, Track t2) {
        if (t1.start == t2.start && t1.end == t2.end) {
            return null;
        }
        if (t1.end < t2.start || t1.start > t2.end) {
            return null;
        }
        return new Track(Math.min(t1.start, t2.start), Math.max(t1.end, t2.end));

    }
}
