package codechef.problems;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RadiatorSprings {

	static double x, y, l, d, w;

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.000000000"); 
		Scanner in =new Scanner(System.in);
		x = in.nextInt();
		y = in.nextInt();
		l = in.nextInt();
		d = in.nextInt();
		w = in.nextInt();
		double time =getSolution();
		System.out.println(new DecimalFormat("##.000000000").format(time));
	}

	private static double getSolution(double a, double b, double c) {
		if (a == 0) {
			return 0;
		}
		double sol = 0.0d;
		double det = Math.sqrt(b * b - 4 * a * c);
		if (det < 0) {
			return 0;
		}
		double temp = (-b + det) / (2 * a);
		if (temp > 0) {
			sol = temp;
		} else {
			sol = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		}
		return sol;
	}

	static double getSolution() {
		if (y <= 0) {
			return 0;
		}
		if (y <= w) {
			double t = y / x;
			double initialDistance = 0.5 * x * Math.pow(t, 2);
			if (d >= l) {
				return Math.sqrt((2 * l) / x);
			}
			double left = (l - initialDistance) / y;
			return t + left;
		} else {
			return getTime();
		}
	}

	static double getTime() {
		double distanceSpeedLimit = (w * w) / (2 * x);
		double distanceMaxSpeed = (y * y) / (2 * x);
		if (distanceSpeedLimit >= l
				|| (distanceSpeedLimit >= d && distanceMaxSpeed >= l)) {
			return Math.sqrt((2 * l) / x);
		} else if (distanceSpeedLimit >= d) {
			double t1 = y / x;
			double t2 = (l - distanceMaxSpeed) / y;
			return (t2 + t1);
		} else {
			double s = Math.sqrt(((2 * x * d) + (w * w)) / 2);
			double t = 0;
			if (s <= y) {
				t = s / x + (s - w) / x;
			} else {
				double a = (y * y) / (2 * x);
				double b = ((y * y) - (w * w)) / (2 * x);
				t = y / x + (y - w) / x + (d - a - b) / y;
			}
			double distanceLimitToMax = ((y * y) - (w * w)) / (2 * x);
			if (distanceLimitToMax > (l - d)) {
				double finalSpeed = Math.sqrt(w * w + 2 * x * (l - d));
				return (t + ((finalSpeed - w) / x));
			}
			double dLeft = l - d - (y * y - w * w) / (2 * x);
			double timeLeft = dLeft / y;
			return (t + (y - w) / x + timeLeft);
		}
	}

}
