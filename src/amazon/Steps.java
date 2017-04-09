package amazon;

public class Steps {
public static void main(String[] args) {
	int steps=10;
	int ways=ways(steps);
	System.out.println(ways);
}

private static int ways(int steps) {
	int ways[] =new int[steps+1];
	ways[1]=1;
	ways[2]=2;
	for(int i=3;i<ways.length;i++){
		ways[i]=ways[i-1]+ways[i-2];
	}
	return ways[steps];
}
}
