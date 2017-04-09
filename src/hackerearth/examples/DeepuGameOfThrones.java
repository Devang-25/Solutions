package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class DeepuGameOfThrones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int rects = in.nextInt();
			List<Rectangle> rectangles = new ArrayList<Rectangle>(rects);
			for (int r = 0; r < rects; r++) {
				Rectangle rect = new Rectangle();
				rect.left = in.nextInt();
				rect.bottom = in.nextInt();
				rect.right = in.nextInt();
				rect.top = in.nextInt();
				rectangles.add(rect);
			}
			System.out.println(rectangles);
			int area=new DeepuGameOfThrones().area(rectangles);
			System.out.println(area);
		}

	}

	static class Rectangle {
		int left;
		int right;
		int top;
		int bottom;
		
		
		public String toString() {
			return "[{"+this.left+","+this.bottom+"}-{"+this.right+","+this.top+"}]";
		}
	}

	class Range {
		int left;
		int right;

		Range(int l, int r) {
			left = (l < r) ? l : r;
			right = (l + r) - left;
		}
		
		public String toString() {
			return left+"-"+right;
		}

		boolean overlaps(Range another) {
			return !(left > another.right || another.left > right);
		}

		void combine(Range other) {
			if (overlaps(other)) {
				left = (left < other.left) ? left : other.left;
				right = (right > other.right) ? right : other.right;
			}
		}
	}

	int area(List<Rectangle> rects) {
		// sort rectangles according to x-value of right edges
		Collections.sort(rects, new RectangleComparator());
		System.out.println(rects);
		List<Integer> allRectanglesX = new ArrayList<Integer>();
		getAllX(rects, allRectanglesX);
		System.out.println("allRectangles X:"+allRectanglesX);
		Collections.sort(allRectanglesX);
		int recIndex = 0;
		int area = 0;
		for (int i = 0; i < allRectanglesX.size() - 1; i++) {
			int x1 = allRectanglesX.get(i);
			int x2 = allRectanglesX.get(i + 1);
			if (x1 < x2) {
				Range rangeX = new Range(x1, x2);
				while (rects.get(recIndex).right < x1)
					++recIndex;
				List<Range> rangesOfY = new ArrayList<Range>();
				
				getRangesOfYForX(rects, recIndex, rangeX, rangesOfY);
				System.out.println("Ranges of Y:"+rangesOfY);
				area += getAreaBetweenTheRange(rangeX, rangesOfY);
			}
		}

		return area;
	}

	void getRangesOfYForX(List<Rectangle> rects, int recIndex, Range rangeX,
			List<Range> rangesOfY) {
		for (int i = recIndex; i != rects.size(); ++i) {
			if (rangeX.left < rects.get(i).right
					&& rangeX.right > rects.get(i).left)
				processYRanges(rangesOfY,
						new Range(rects.get(i).top, rects.get(i).bottom));
		}
	}

	void processYRanges(List<Range> rangesOfY, Range rangeY) {
		ListIterator<Range> iter = rangesOfY.listIterator();
		while (iter.hasNext()) {
			Range r = iter.next();
			if (rangeY.overlaps(r)) {
				rangeY.combine(r);
				iter.remove();
			}
		}

		rangesOfY.add(rangeY);
	}

	class RectangleComparator implements Comparator<Rectangle> {
		public int compare(Rectangle rect1, Rectangle rect2) {
			return (rect1.right - rect2.right);
		}
	}

	void getAllX(List<Rectangle> rects, List<Integer> xes) {
		Iterator<Rectangle> iter = rects.iterator();
		while (iter.hasNext()) {
			Rectangle r = iter.next();
			xes.add(r.left);
			xes.add(r.right);
		}
	}

	int getAreaBetweenTheRange(Range rangeX, List<Range> rangesOfY) {
		int width = rangeX.right - rangeX.left;

		Iterator<Range> iter = rangesOfY.iterator();
		int area = 0;
		while (iter.hasNext()) {
			Range r = iter.next();
			int height = r.right - r.left;
			area += width * height;
		}

		return area;
	}
}
