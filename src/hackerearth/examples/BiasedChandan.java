package hackerearth.examples;

import java.util.Scanner;

public class BiasedChandan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        java.util.Stack<Integer> s = new java.util.Stack();
        for (int i = 0; i < n; i++) {
            int rating = in.nextInt();
            if (rating == 0) {
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(rating);
            }
        }
        long sum=0;
        while(!s.isEmpty()){
            sum+=s.pop();
        }
        System.out.println(sum);
    }
}
