package codechef.problems;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class PackingTheGoldenTriangleTester {

  
    public int task(int N,int M,  List<Long> boxz, Long rubL[], Long rubU[]) throws IOException {    	    	
    	long[] boxes = new long[N];
    	for(int i = 0; i < N; i++){
    		boxes[i] = 7*4*boxz.get(i);
    	}
    	long[][] rubbers = new long[M][];
    	for(int i = 0; i < M; i++){
    		rubbers[i] = new long[]{rubL[i]*44, rubU[i]*44};
    	}
    	Arrays.sort(boxes);
    	Arrays.sort(rubbers, new Comparator<long[]>(){
    		public int compare(long[] r1, long[] r2){
    			return r1[0] < r2[0]? -1: 1;
    		}
    	});
    	
    	PriorityQueue<Long> pq = new PriorityQueue<Long>(11, new Comparator<Long>(){
    		public int compare(Long o1, Long o2) {
    			return o1 < o2? -1 : 1;
			}
    	});
    	
    	int answer = 0;
    	int curB = 0;
    	int curR = 0;
    	while( curB < N){
    		while( curR < M && rubbers[curR][0] <= boxes[curB] ){
//    			out.println("inserting: " + rubbers[curR][1] );
    			pq.add( rubbers[curR][1] );
    			curR++;
    		}
    		while( !pq.isEmpty() && pq.peek() < boxes[curB] ){
//    			out.println("removing: " + pq.peek());
    			pq.poll();
    		}
    		
    		if( !pq.isEmpty() ){
//    			out.println("removing (score): " + pq.peek());
    			answer++;
    			pq.poll();    			
    		}
    		curB++;    		
    	}
    	return answer;
    }
 
}