package geek.examples;

public class RemoveHalfNodes {
	public static void main(String[] args) {
		Node[] n=new Node[12];
		for(int i=0;i<n.length;i++){
			n[i]=new Node(i);
		}
		n[1].left=n[2];
		n[1].right=n[3];
		n[2].right=n[4];
		n[3].right=n[5];
		n[4].right=n[6];
		n[5].left=n[7];
		n[6].left=n[8];
		n[8].left=n[9];
		n[8].right=n[10];
		n[10].right=n[11];
		n[1]=fixHalf(n[1]);
		System.out.println(n[1].left+"-"+n[1].right);
		
	}

	private static Node fixHalf(Node root) {
		if (root == null) {
			return null;
		}
		Node cur = root;
		while (isHalf(cur)) {
			if (cur.left != null) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		cur.left = fixHalf(cur.left);
		System.out.println(cur.val+".L->"+(cur.left==null?"*":cur.left));
		cur.right = fixHalf(cur.right);
		System.out.println(cur.val+".R->"+(cur.right==null?"*":cur.right));
		return cur;
	}

	private static boolean isHalf(Node root) {
		return (root.left == null && root.right != null)
				|| (root.left != null && root.right == null);
	}

	static class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.val+"";
		}
	}
}
