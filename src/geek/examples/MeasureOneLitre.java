package geek.examples;

public class MeasureOneLitre {
public static void main(String[] args) {
	int a=20; 
	int b=99;
	int v1=0;
	int v2=0;
	while(v1!=1){
		if(v1==0){
			System.out.println("Fill v1 to "+a);
			v1=a;
		}
		if(b-v2>v1){
			v2+=v1;
			System.out.println("Transfer v1 to v2 "+ v2);
		}else{
			v1-=(b-v2);
			System.out.println("Empty b");
			v2=0;
		}
	}
	System.out.println("done");
}
}
