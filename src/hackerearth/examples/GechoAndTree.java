package hackerearth.examples;

import java.math.BigInteger;
import java.util.Scanner;
class GechoAndTree
{
    public static void main(String args[])
    {
	   Scanner scanner=new Scanner(System.in);
	   int testcases=scanner.nextInt();
	   for(int t=1;t<=testcases;t++)
	   {
		 int k=scanner.nextInt();
		 int n=scanner.nextInt();  
         BigInteger kbig=new BigInteger(k+"");
         BigInteger kMinus1=kbig;
         String nodesString;
         BigInteger kPowerNPlusOne=kbig.pow(n+1);
         kPowerNPlusOne=kPowerNPlusOne.subtract(new BigInteger("1"));
         kMinus1=kMinus1.subtract(new BigInteger("1"));
         BigInteger nodes=kPowerNPlusOne.divide(kMinus1);
         nodesString=nodes.toString();
         int sum=0;
         for(int i=0;i<nodesString.length();i++)
         {
           sum+=nodesString.charAt(i)-'0';
         }
         System.out.println(sum);
	 }
    }
}