package codechef.problems;

import java.util.Scanner;

public class TWTCLOSE {
	private static final boolean CLOSED=false;
	private static final boolean OPENED=true;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tweets = in.nextInt();
		int clicks = in.nextInt();
		boolean state[] = new boolean[tweets];
		int open=0;
		for(int i=1;i<=clicks;i++){
			String code=in.next();
			if(code.equals("CLICK")){
				int tweetId=in.nextInt()-1;
				if(state[tweetId]==CLOSED){
					state[tweetId]=OPENED;
					open++;
				}else {
					state[tweetId]=CLOSED;
					open--;
				}
			}else {
				state = new boolean[tweets];
				open=0;
			}
			System.out.println(open);
		}
	}
}
