package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;

/*An algorithm to print all the 10-digit nos 
 * such that first 1 digit is divisible by 1, first 2 digits by 2, first 3 digits by 3 and so on…first 9 digits by 9. 
 * I think the tenth digit can be anything from 0 to 9.*/
public class SpecialNumbers {
	List<Long> specialNumbers = new ArrayList<Long>();

	public void findSpecialNumbers() {
		verify(0, 1);
		System.out.println(specialNumbers);
	}

	void verify(long no, int div) {
		if (div == 9) {
			if (no == 0) {
				return;
			}
			for (int i = 1; i <= 9; i++) {
				long mul = (int) (Math.pow(10, div));
				System.out.println("accepted :" + (mul * i + no));
				specialNumbers.add(mul * i + no);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			long mul = (int) (Math.pow(10, div));
			long newNo = mul * i + no;
			if (newNo % (div + 1) == 0) {
				System.out.print("Level " + (div + 1) + "\t" + newNo + "\tmul"
						+ mul);
				verify(newNo, div + 1);
			} else {
				System.out.println("Level " + (div + 1) + "\t" + newNo
						+ " failed");
			}

		}
	}

	public static void main(String args[]) {
		SpecialNumbers numbers = new SpecialNumbers();
		numbers.findSpecialNumbers();
	}
}
