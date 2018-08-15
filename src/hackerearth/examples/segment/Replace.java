package hackerearth.examples.segment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Replace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int queries = in.nextInt();
        Integer x[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        SegmentTree<Integer, Map<Integer, Integer>> segmentTree = new SegmentTree<>(x, x.length, (c, ov, nv) -> {
            if (c.containsKey(ov)) {
                c.putIfAbsent(nv, 0);
                c.put(nv, c.get(nv) + c.get(ov));
                c.remove(ov);
            }
            return c;
        }, v -> {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(v, 1);
            return map;
        }, (m, p) -> {
            if (m == null) {
                return p;
            }
            if (p == null) {
                return m;
            }
            Map<Integer, Integer> map = new HashMap<>(m);
            for (Map.Entry<Integer, Integer> e : p.entrySet()) {
                map.putIfAbsent(e.getKey(), 0);
                map.put(e.getKey(), map.get(e.getKey()) + e.getValue());
            }
            return map;
        });
        for (int q = 1; q <= queries; q++) {
            int qType = in.nextInt();
            if (qType == 1) {
                int a = in.nextInt();
                int b = in.nextInt();
                int from = in.nextInt();
                int to = in.nextInt();
                segmentTree.updateValue(x.length, a - 1, b - 1, from, to);
            }
            if (qType == 2) {
                int a = in.nextInt();
                int b = in.nextInt();
                int v = in.nextInt();
                Integer freq = segmentTree.get(x.length, a - 1, b - 1).getOrDefault(v, 0);
                System.out.println(freq);
            }

        }

    }

    interface TriFunc<X, Y> {
        X apply(X a, Y b, Y c);
    }

    private static class SegmentTree<T, R> {
        ArrayList<R> st;
        private final TriFunc<R, T> diff;
        private Function<T, R> constraint;
        private final BiFunction<R, R, R> merge;

        SegmentTree(T arr[], int n, TriFunc<R, T> diff, Function<T, R> constraint, BiFunction<R, R, R> merge) {
            this.diff = diff;
            this.constraint = constraint;
            this.merge = merge;
            //Height of segment tree
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            //Maximum size of segment tree
            int max_size = 2 * (int) Math.pow(2, x) - 1;

            st = new ArrayList<>(max_size); // Memory allocation
            for (int i = 0; i < max_size; i++) {
                st.add(null);
            }
            constructSTUtil(arr, 0, n - 1, 0);
        }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }


        R getSegmentValue(int ss, int se, int qs, int qe, int si) {
            // If segment of this node is a part of given range
            if (qs <= ss && qe >= se)
                return st.get(si);

            // If segment of this node is outside the given range
            if (se < qs || ss > qe)
                return null;

            // If a part of this segment overlaps with the given range
            int mid = getMid(ss, se);
            return this.merge.apply(getSegmentValue(ss, mid, qs, qe, 2 * si + 1),
                    getSegmentValue(mid + 1, se, qs, qe, 2 * si + 2));
        }


        void updateValueUtil(int ss, int se, int qs, int qe, T oldValue, T newValue, int si) {
            //the case of total overlap.
            if (qs <= ss && qe >= se)
                st.set(si, this.diff.apply(st.get(si), oldValue, newValue));

            //the case of no overlap.
            if (se < qs || ss > qe)
                return;
            if (se != ss) {
                int mid = getMid(ss, se);
                updateValueUtil(ss, mid, qs, qe, oldValue, newValue, 2 * si + 1);
                updateValueUtil(mid + 1, se, qs, qe, oldValue, newValue, 2 * si + 2);
            }
        }

        void updateValue(int n, int qs, int qe, T old_value, T new_val) {
            // Update the values of nodes in segment tree
            updateValueUtil(0, n - 1, qs, qe, old_value, new_val, 0);
        }


        // Return sum of elements in range from index qs (quey start) to
        // qe (query end).  It mainly uses getSegmentValue()
        R get(int n, int qs, int qe) {
            // Check for erroneous input values
            if (qs < 0 || qe > n - 1 || qs > qe) {
                System.err.println("Invalid Input");
                return null;
            }
            return getSegmentValue(0, n - 1, qs, qe, 0);
        }

        // A recursive diff that constructs Segment Tree for array[ss..se].
        // si is index of current node in segment tree st
        R constructSTUtil(T arr[], int ss, int se, int si) {
            // If there is one element in array, store it in current node of
            // segment tree and return
            if (ss == se) {
                st.set(si, constraint.apply(arr[ss]));
                return st.get(si);
            }

            // If there are more than one elements, then recur for left and
            // right subtrees and store the sum of values in this node
            int mid = getMid(ss, se);
            st.set(si, this.merge.apply(constructSTUtil(arr, ss, mid, si * 2 + 1),
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2)));
            return st.get(si);
        }
    }


}
