package geek.examples.amazon;
public final  class RecursiveNoOfbalancedBrackets
 extends NoOfbalancedBrackets
{
//============= F I E L D S ======================
private int tab=0;
//============= C O N S T R U C T O R S ==========
public RecursiveNoOfbalancedBrackets()
{
 super();
}

//============= M E T H O D S ====================
public void generate(int p0,java.lang.String p1){
 display(++tab);
System.out.println("generate("+p0+","+p1+")");
super.generate(p0,p1);
display(--tab);
}
private void display(int tab){
for(int i=1;i<=tab;i++){
System.out.print("   ");
}
}
//============= N E S T E D C L A S S E S ======
}
