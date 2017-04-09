package hackerearth.examples;

public class KthFromLast {
	static class Node {
		public Node(int i) {
			this.val=i;
		}
		int val;
		Node next;
	}

	public static int  findKthFromLast(Node start, int k) {
		return pos(start, k);
	}
	
	static int pos(Node node, int k){
		if(node.next==null){
			if(k==1){
				System.out.println(node.val);
			}
			return 1;
		}
		int pos= pos(node.next, k)+1;
		if(pos==k){
			System.out.println(node.val);
		}
		return pos;
	}
	
	public static void main(String args[]){
		int arr[]={1,2,/*3,4,5,6,7,8,9*/};
		//3 from last is 7.
		Node start=new Node(arr[0]);
		Node temp=start;
		for(int i=1;i<arr.length;i++){
			temp.next=new Node(arr[i]);
			temp=temp.next;
		}
		findKthFromLast(start, 1);
		
	}
}
