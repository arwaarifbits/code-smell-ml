
public class DriverCls {
public void finalize() {
	System.out.println("object is garbage collected");
	
}
void f1() {
	System.out.println("Hello...java");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DriverCls s1 = new DriverCls();
DriverCls s2 = new DriverCls();
s1.f1();


System.gc();

	}

}
