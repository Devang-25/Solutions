package hackerearth.examples;

public class LargestPalindromeProduct {
public static void main(String[] args) {
	System.out.println(isPalindrome("ab"));
	long max=Integer.MIN_VALUE;
	for(int i=999;i>=100;i--){
		for (int j = i; j >= 100; j--) {
			System.out.println(i*j);
			if(isPalindrome((i*j)+"")){
				System.out.println(i*j);
				if((i*j)>max){
					max=i*j;
				}
			}
		}
	}
	System.out.println(max);
}

private static boolean isPalindrome(String string) {
	for(int i=0;i<string.length()/2;i++){
		if(string.charAt(i)!=string.charAt(string.length()-i-1)){
			return false;
		}
	}
	return true;
}
}
