package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class GhissuDeepak {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			TreeSet<Book> booksSet = new TreeSet<Book>(new WeightComparator());
			int N = in.nextInt();
			Book strongestBook = new Book(0, Integer.MIN_VALUE);
			/*O(nlogn+n)*/
			for (int j = 1; j <= N; j++) {
				Book b = new Book(in.nextInt(), in.nextInt());
				if (b.remWeight > strongestBook.remWeight) {
					strongestBook = b;
				}
				booksSet.add(b);
			}
			//System.out.println(booksSet);
			//System.out.println("Strongest is " + strongestBook);
			strongestBook.isUsed = true;
			System.out.println(1 + getBooks(booksSet, new Book(
					strongestBook.remWeight, 2*strongestBook.remWeight)));
		}
	}

	static int tab = 0;

	static int getBooks(TreeSet<Book> set, Book book) {
		tab(book+"",++tab);
		//O(log n)
		SortedSet<Book> lowerWeightBooks = set.headSet(book, true);
		tab(lowerWeightBooks+"",tab);
		if (lowerWeightBooks.isEmpty()) {
			tab("",--tab);
			return 0;
		}
		int max = Integer.MIN_VALUE;
		boolean atLeast1UnUsed = false;
		for (Book b : lowerWeightBooks) {
			if (!b.isUsed) {
				tab("Picked :" + b,tab);
				atLeast1UnUsed = true;
				b.isUsed = true;
				int maxBookBeCarried = 0;
				if (b.remWeight <= book.remWeight - b.weight) {
					tab("A",tab);
					maxBookBeCarried = getBooks(set, b);
				} else {
					tab("B",tab);
					int m=book.remWeight-b.weight;
					maxBookBeCarried = getBooks(set, new Book(m,
							2*m));
				}
				tab(maxBookBeCarried+"",tab);
				if (max < maxBookBeCarried) {
					max = maxBookBeCarried;
				}
				b.isUsed = false;
			}
		}
		if (!atLeast1UnUsed) {
			tab("",--tab);
			return 0;
		}
		//System.out.println("Maxx:" + (1 + max));
		tab("",--tab);
		return 1 + max;
	}

	static class Book {
		int weight;
		int remWeight;
		int left = 0;
		boolean isUsed = false;

		Book(int weight, int strength) {
			this.weight = weight;
			this.remWeight = strength - weight;
			this.left = this.remWeight;
		}

		@Override
		public String toString() {
			return this.weight + " ;S=" + this.remWeight+": U:"+this.isUsed;
		}
	}

	static class WeightComparator implements Comparator<Book> {

		public int compare(Book b1, Book b2) {
			if (b1.weight <= b2.weight) {
				return -1;
			}
			return 1;
		}

	}

	private static void tab(String s, int t) {
		for (int i = 1; i <= t; i++) {
			System.out.print("  ");
		}
		if(!s.equals("")){
			System.out.println(s);
		}
		
	}
}
