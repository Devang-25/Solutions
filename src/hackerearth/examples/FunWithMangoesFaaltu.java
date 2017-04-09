package hackerearth.examples;

public class FunWithMangoesFaaltu {
	public static void main(String[] args) {

	}

	class Interval {
		int s;
		int e;
		int v;

		public Interval(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		public void  intersect(Interval i) {
			Interval n = this;
			if (n.e < i.s) {
				// do nothing
			} else if (n.e >= i.s && n.e < i.e) {
				if (n.s < i.s) {
					Interval a = new Interval(n.s, i.s, n.v);
					Interval b = new Interval(i.s, n.e, n.v + i.v);
					Interval c = new Interval(n.e, i.e, i.v);
				} else if (n.s == i.s) {
					Interval b = new Interval(i.s, n.e, n.v + i.v);
					Interval c = new Interval(n.e, i.e, i.v);
				} else {
					Interval a = new Interval(i.s, n.s, i.v);
					Interval b = new Interval(n.s, n.e, n.v + i.v);
					Interval c = new Interval(n.e, i.e, i.v);
				}

			} else if (n.e == i.e) {
				if (n.s > i.s) {
					Interval a = new Interval(i.s, n.s, i.v);
					Interval b = new Interval(n.s, n.e, n.v + i.v);
				} else if (n.s < i.s) {
					Interval a = new Interval(n.s, i.s, n.v);
					Interval b = new Interval(n.s, n.e, n.v + i.v);
				} else {
					Interval b = new Interval(n.s, n.e, n.v + i.v);
				}
			} else if (n.e > i.e) {
				if (n.s < i.s) {
					
				} else if (n.s == i.s) {
				} else if (n.s > i.s && n.s <= i.e) {
				}
			}
		}
	}
}
