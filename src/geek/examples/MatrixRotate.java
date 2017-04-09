package geek.examples;

public class MatrixRotate {
	public static int[][] rotate(int[][] arr) {
		int[][] newArray = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = arr[i].length - 1; j >= 0; j--) {
				newArray[i][arr[i].length-j-1] = arr[j][i];
			}
		}
		return newArray;
	}
	public static void main(String args[]){
		int arr[][]={{1,2,3},{4,5,6}};
		display(arr);
		arr=rotate(arr);
		System.out.println();
		display(arr);
	}
	public static void display(int arr[][]){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
