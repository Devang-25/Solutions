package codechef.problems;

import java.util.Scanner;

public class TYTACTIC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		Node [] soldiers=new Node[N+1];
		for(int i=1;i<=N;i++){
			int skill=in.nextInt();
			soldiers[i]=new Node(skill);
		}
		for(int a=1;a<=N-1;a++){
			int u=in.nextInt();
			int v=in.nextInt();
			Node sub=null;
			if(u==1|| soldiers[u].superior!=null){
				soldiers[v].superior=soldiers[u];
				sub=soldiers[v];
			}else {
				soldiers[u].superior=soldiers[v];
				sub=soldiers[u];
			}
			Node temp=sub;
			int skill=temp.skill;
			temp=temp.superior;
			while(temp!=null){
				temp.skillUnder+=skill;
				temp=temp.superior;
			}
		}
		//System.out.println(Arrays.asList(soldiers));
		for(int q=1;q<=Q;q++){
			String code=in.next();
			if(code.equals("U")){
				int s=in.nextInt();
				int x=in.nextInt();
				int diff=x-soldiers[s].skill;
				soldiers[s].skill=x;
				soldiers[s].skillUnder+=diff;
				if(diff!=0){
					Node temp=soldiers[s].superior;
					while(temp!=null){
						temp.skillUnder+=diff;
						temp=temp.superior;
					}
				}
			}else{
				int s=in.nextInt();
				System.out.println(soldiers[s].skillUnder);
			}
			
		}
	}

	static class Node {
		static int id=0;
		int skill;
		int id_;
		int skillUnder;
		Node superior;

		public Node(int skill) {
			id++;
			id_=id;
			this.skill = skill;
			this.skillUnder = this.skill;
		}
		
		public String toString() {
			return this.id_+":"+skill+" "+skillUnder;
		};
	}
}
