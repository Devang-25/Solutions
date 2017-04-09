package geek.examples;
//Collect maximum coins before hitting a dead end
public class MaxCoinsBeforeDeadEnd {
	private static final boolean RIGHT=true;
	private static final boolean LEFT=false;
public static void main(String[] args) {

	char[][] cells=new char[][]{ {'E', 'C', 'C', 'C', 'C'},
        {'C', '#', 'C', '#', 'E'},
        {'#', 'C', 'C', '#', 'C'},
        {'C', 'E', 'E', 'C', 'E'},
        {'C', 'E', '#', 'C', 'E'}
      };
      
     int max=maxCoinsPath(cells,0,0, RIGHT);
     System.out.println(max);
}
private static int maxCoinsPath(char[][] cells,int i, int j, boolean right) {
	if(cells[i][j]=='#'){
		return 0;
	}
	int coins=0;
	if(cells[i][j]=='C'){
		coins= 1;
	}
	int max=Integer.MIN_VALUE;
	if(right){
		if(j+1!=cells[0].length){
			max=maxCoinsPath(cells, i, j+1, right);
		}
		if(i+1!=cells.length){
			int m=maxCoinsPath(cells, i+1, j, !right);
			if(m>max){
				max=m;
			}
		}
		return coins+max;
	}
	if(j-1!=-1){
		max=maxCoinsPath(cells, i, j-1, right);
	}
	if(i+1!=cells.length){
		int m=maxCoinsPath(cells, i+1, j, !right);
		if(m>max){
			max=m;
		}
	}
	return coins+max;
	
	
}
}
