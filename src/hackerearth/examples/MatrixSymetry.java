package hackerearth.examples;

import java.util.Scanner;

public class MatrixSymetry {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int testCases=in.nextInt();
		for(int i=1;i<=testCases;i++){
			int sizeOfMatrix=in.nextInt();
			char[][] matrix=new char[sizeOfMatrix][sizeOfMatrix];
			for(int j=0;j<sizeOfMatrix;j++){
				String row=in.next();
				char [] rowC=row.toCharArray();
				for(int m=0;m<rowC.length;m++){
					matrix[j][m]=rowC[m];
				}
			}
			boolean isH=isHorizontallySymetrical(matrix);
			boolean isV=isVerticallySymetrical(matrix);
			if(isH&& isV){
				System.out.println("BOTH");
			}else if(isH){
				System.out.println("HORIZONTAL");
			}else if(isV){
				System.out.println("VERTICAL");
			}else{
				System.out.println("NO");
			}
		}
	}

	public static boolean isHorizontallySymetrical(char[][] a) {
		for(int i=0;i<a.length/2;i++){
			for(int j=0;j<a.length;j++){
				if(a[i][j]!=a[a.length-1-i][j]){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isVerticallySymetrical(char[][] a) {
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length/2;j++){
				if(a[i][j]!=a[i][a.length-1-j]){
					return false;
				}
			}
		}
		return true;
	}
}
