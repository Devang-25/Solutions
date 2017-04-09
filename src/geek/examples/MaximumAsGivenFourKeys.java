package geek.examples;

public class MaximumAsGivenFourKeys {
	public static void main(String[] args) {
//		long a2=findoptimalDP(100000);
//		System.out.println(a2);
		int a=findOptimalRecursive(80);
		System.out.println(a);
		
	}

	private static int findOptimalRecursive(int n) {
		if (n < 7) {
			return n;
		}
		int max = Integer.MIN_VALUE;
		for (int b = n - 3; b >= 1; b--) {
			int sol = (n - b - 1) * findOptimalRecursive(b);
			if (sol > max) {
				max = sol;
			}
		}
		return max;
	}
	
	// this function returns the optimal length string for N keystrokes
	private static long findoptimalDP(int N)
	{
	    // The optimal string length is N when N is smaller than 7
	    if (N <= 6)
	        return N;
	 
	    // An array to store result of subproblems
	    long screen[]=new long[N];
	 
	    int b;  // To pick a breakpoint
	 
	    // Initializing the optimal lengths array for uptil 6 input
	    // strokes.
	    for (int i=1; i<=6; i++)
	        screen[i-1] = i;
	 
	    // Solve all subproblems in bottom manner
	    for (int i=7; i<=N; i++)
	    {
	        // Initialize length of optimal string for i keystrokes
	        screen[i-1] = 0;
	 
	        // For any keystroke i, we need to loop from i-3 keystrokes
	        // back to 1 keystroke to find a breakpoint 'b' after which we
	        // will have ctrl-a, ctrl-c and then only ctrl-v all the way.
	        for (b=i-3; b>=1; b--)
	        {
	            // if the breakpoint is at b'th keystroke then
	            // the optimal string would have length
	            // (n-b-1)*screen[b-1];
	            long curr = (i-b-1)*screen[b-1];
	            if (curr > screen[i-1])
	                screen[i-1] = curr;
	        }
	    }
	 
	    return screen[N-1];
	}
}
