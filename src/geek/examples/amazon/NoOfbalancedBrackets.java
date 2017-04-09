/**
 * 
 */
package geek.examples.amazon;

import recursion.gen.RecursionTrackerGenerator;


/**
 * @author makkg
 *
 */
public class NoOfbalancedBrackets{
	public static void main(String[] args) throws Exception {
		RecursionTrackerGenerator constructor=new RecursionTrackerGenerator(NoOfbalancedBrackets.class);
		NoOfbalancedBrackets a=(NoOfbalancedBrackets) constructor.createClass().newInstance();
		//RecursiveNoOfbalancedBrackets  a=new RecursiveNoOfbalancedBrackets();
		a.generate(6, "");
	}

	
	public void generate(int n, String str) {
		if (n == 0) {
			System.out.println(str);
			return;
		}
		generate(n - 2, "(" + str + ")");
		generate(n - 2, "()" + str);
	}

}

