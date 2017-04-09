/**
 * 
 */
package geek.examples;

/**
 * @author makkg
 *
 */
public class WordWrapWrong {
	private static int len[] = null;

	public static void main(String[] args) {
		//String input = "Geeks for geeks presents word wrap problem";
		String input="ab bc cde fghi ijklm no pq";
		int M = 15;
		String words[] = input.split(" ");
		/*
		 * int sum = 0; for (int i = 0; i < words.length; i++) { sum +=
		 * words[i].length(); len[i] = sum; sum++; }
		 */
		int cost = new WordWrapWrong().cost(words, 0, M);
		System.out.println(cost);
	}

	/**
	 * @param split
	 * @param m
	 * @return
	 */
	public  int cost(String[] wrds, int index, int m) {
		if (index == wrds.length) {
			return 0;
		}
		int i=index;
		System.out.println("cost(" + wrds[i] + "," + m + ")");
		int len = wrds[i].length();
		int minCost = Integer.MAX_VALUE;
		while (len <= m) {
			int left = m - len;
			display(wrds, index, i);
			int cost =(int)Math.pow(left, 3)+ cost(wrds, i + 1, m);
			display(wrds, index, i);
			System.out.println("cost :"+cost);
			if (cost < minCost) {
				minCost = cost;
			}
			i++;
			if (i < wrds.length) {
				len += wrds[i].length() + 1;
			}else{
				break;
			}
		}
		return minCost;
	}

	/**
	 * @param wrds
	 * @param index
	 * @param i
	 */
	private  void display(String[] wrds, int index, int i) {
		String w="";
		for(int j=index;j<=i;j++){
			w+=wrds[j]+" ";
		}
		System.out.println(w);
		
	}
}
