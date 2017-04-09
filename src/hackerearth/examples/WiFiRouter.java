package hackerearth.examples;

import java.util.Scanner;
/*did n't work :( */
public class WiFiRouter {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int noOfRouters = in.nextInt();
			int noOfUsers = in.nextInt();
			int routerX[] = new int[noOfRouters];
			int routerY[] = new int[noOfRouters];
			int userX[] = new int[noOfUsers];
			int userY[] = new int[noOfUsers];
			for (int j = 0; j < noOfRouters; j++) {
				routerX[j] = in.nextInt();
				routerY[j] = in.nextInt();
			}
			for (int j = 0; j < noOfUsers; j++) {
				userX[j] = in.nextInt();
				userY[j] = in.nextInt();
			}
			double farthestUser = Double.MIN_VALUE;
			for (int u = 0; u < userX.length; u++) {
				int uX = userX[u];
				int uY = userY[u];
				double nearestRouter = Double.MAX_VALUE;
				for (int r = 0; r < routerX.length; r++) {
					int rX = routerX[r];
					int rY = routerY[r];
					double distance = Math.pow(rX - uX, 2)
							+ Math.pow(rY - uY, 2);
					if (distance < nearestRouter) {
						nearestRouter = distance;
					}
				}
				if (farthestUser < nearestRouter) {
					farthestUser = nearestRouter;
				}
			}
			farthestUser=Math.sqrt(farthestUser);
			System.out.println(farthestUser);
			farthestUser = Math.round(farthestUser * 1000000) / 1000000.0;
			System.out.println(farthestUser);
			double maxDBwR=Double.MIN_VALUE;
			for (int r = 0; r < routerX.length; r++) {
				int rX = routerX[r];
				int rY = routerY[r];
				for (int t = r+1; t < routerX.length; t++) {
					int tX = routerX[t];
					int tY = routerY[t];
					double distance = Math.sqrt(Math.pow(rX - tX, 2)
							+ Math.pow(rY - tY, 2));
					if(distance>maxDBwR){
						maxDBwR=distance;
					}
				}
			}
			maxDBwR=Math.round(maxDBwR * 1000000) / 1000000.0;
			System.out.println(Math.max(farthestUser, maxDBwR));
		}

	}
}
