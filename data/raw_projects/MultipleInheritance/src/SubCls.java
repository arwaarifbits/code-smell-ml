
public class SubCls extends SuperCls implements SuperInf {
public void f1() {
	System.out.println("Super interface exe..");
	
}
void f3() {
	f2(); //super cls method
	System.out.println("Sub Cls exe...");
}
}
