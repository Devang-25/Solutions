
package hackerearth.examples;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class AliceGame2 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in =new Scanner(System.in);
        int testCases=in.nextInt();
        for (int i = 0; i<testCases; i++) {
            Map<Integer, Integer> boxes=new LinkedHashMap<Integer,Integer>();
            int boxesCount=in.nextInt();
            for (int j = 0; j < boxesCount; j++) {
                int chocolates=in.nextInt();
                if(j==0)
                    boxes.put(chocolates, 1);
                else {
                    if(boxes.containsKey(chocolates)){
                        boxes.put(chocolates, boxes.get(chocolates)+1);
                    }
                    else{
                        boxes.put(chocolates, 1);
                    }
                }    
            }
            int k=in.nextInt();
            boolean itself=false;
            int ways=0;
            for (Integer ith: boxes.keySet()) {
                itself=false;
                for (Integer kMinusIth : boxes.keySet()) {
                    if(ith==kMinusIth){
                        itself=true;
                    }
                    else if(itself){
                        if(k==kMinusIth+ith){
                            ways+=boxes.get(kMinusIth)*boxes.get(ith);
                        }
                    }
                }
            }
            if(k%2==0){
                if(boxes.containsKey(k/2)){
                    for (int j = 1; j < boxes.get(k/2); j++) {
                        ways+=j;
                    }
                }
            }
            System.out.println(ways);
        }
    }

}