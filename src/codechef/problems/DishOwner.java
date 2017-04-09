package codechef.problems;

import java.util.Scanner;

public class DishOwner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int noOfChefs = in.nextInt();
			Dish[] dishes = new Dish[noOfChefs + 1];
			for (int i = 1; i < dishes.length; i++) {
				Dish d = dishes[i] = new Dish(in.nextInt());
				d.owner = i;
			}
			int queries=in.nextInt();
			StringBuilder buffer=new StringBuilder();
			for(int q=1;q<=queries;q++){
				int code=in.nextInt();
				if(code==0){
					Dish a=dishes[in.nextInt()];
					Dish b=dishes[in.nextInt()];
					Dish repA=getRepresentative(a);
					Dish repB=getRepresentative(b);
					if(repA==repB){
						buffer.append("Invalid query!");
					}else{
						if(repA.rating<repB.rating){
							repA.rep=repB;
						}else{
							repB.rep=repA;
						}
					}
				}else if(code==1){
					buffer.append(getRepresentative(dishes[in.nextInt()]).owner);
				}
				if(q!=queries){
					buffer.append("\n");
				}
			}
			System.out.println(buffer.toString());
		}
	}

	private static Dish getRepresentative(Dish a) {
		if(a.rep==a){
			return a;
		}
		a.rep=getRepresentative(a.rep);
		return a.rep;
	}

	static class Dish {
		int owner;
		Dish rep;
		final int rating;

		public Dish(int rating) {
			this.rating = rating;
			this.rep=this;
		}
	}
}
