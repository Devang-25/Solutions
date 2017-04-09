package hackerearth.examples;

public class ProductiveProductivity {
	public static void main(String ars[]) {
		// Let us create a bpGraph shown in the above example
		int bpGraph[][] = { { 0, 1, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 } };
		System.out.println(maxBPM(bpGraph));
	}
	
	// A DFS based recursive function that returns true if a
	// matching for vertex u is possible
	static boolean bpm(int bpGraph[][], int u, boolean seen[], int matchR[]) {
		// Try every job one by one
		for (int v = 0; v < bpGraph[0].length; v++) {
			// If applicant u is interested in job v and v is
			// not visited
			if (!seen[v]) {
				seen[v] = true; // Mark v as visited

				// If job 'v' is not assigned to an applicant OR
				// previously assigned applicant for job v (which is matchR[v])
				// has an alternate job available.
				// Since v is marked as visited in the above line, matchR[v]
				// in the following recursive call will not get job 'v' again
				if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR)) {
					matchR[v] = u;
					return true;
				}
			}
		}
		return false;
	}

	// Returns maximum number of matching from M to N
	static int maxBPM(int[][] bpGraph) {
		// An array to keep track of the applicants assigned to
		// jobs. The value of matchR[i] is the applicant number
		// assigned to job i, the value -1 indicates nobody is
		// assigned.
		int matchR[] = new int[bpGraph[0].length];
		for(int i=0;i<matchR.length;i++){
			matchR[i]=-1;
		}

		int result = 0; // Count of jobs assigned to applicants
		for (int u = 0; u < bpGraph.length; u++) {
			// Mark all jobs as not seen for next applicant.
			boolean seen[] = new boolean[bpGraph.length];

			// Find if the applicant 'u' can get a job
			if (bpm(bpGraph, u, seen, matchR))
				result++;
		}
		return result;
	}
}

