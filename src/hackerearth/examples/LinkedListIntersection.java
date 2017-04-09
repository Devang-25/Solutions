package hackerearth.examples;

public class LinkedListIntersection {
	static class Node {
		int val;
		Node next;

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public static Node findIntersectionPoint(Node start1, Node start2) {
		while(start1!=null){
			Node start2Ptr=start2;
			while(start2Ptr!=null){
				if(start1==start2Ptr){
					return start1;
				}
				start2Ptr=start2Ptr.next;
			}
			start1=start1.next;
		}
		return null;
	}

	public static void main(String arag[]) {
		Node common=new Node(30,null);
		Node intersection=new Node(15, common);
		Node prev1=new Node(9,intersection);
		Node prev2=new Node(13,intersection);
		Node nodeA=new Node(6, prev1);
		Node nodeAS=new Node(3, nodeA);
		Node nodeBS=new Node(10,prev2);
		Node ints=findIntersectionPoint(nodeAS, nodeBS);
		System.out.println(ints.val);
	}

}
