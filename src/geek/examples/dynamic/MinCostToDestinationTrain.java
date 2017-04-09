package geek.examples.dynamic;

public class MinCostToDestinationTrain {
	private static int dist[][];
	public static void main(String[] args) {
		 dist = new int[][]{ { 0, 15, 80, 90 }, { -1, 0, 40, 50 },
				{ -1, -1, 0, 70 }, { -1, -1, 0, 0 } };
		int cost=cost(0,dist.length-1);
		System.out.println(cost);
	}

	private static int cost(int i, int j) {
		if(i==j){
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int k=i+1;k<=j;k++){
			System.out.println(i+";"+k);
			System.out.println(dist[i][k]+";"+k);
			int c=dist[i][k]+cost(k,j);
			System.out.println("cost:"+c);
			if(min>c){
				min=c;
			}
		}
		return min;
	}

}
