package hasarelationship;

public class DerivedCls extends SubCls {
	void f3() {
		f2();//sub cls method
		System.out.println("Derived cls exe...");
	}

}
