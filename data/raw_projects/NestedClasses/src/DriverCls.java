
public class DriverCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
OuterCls out; //outer cls object
OuterCls.InnerCls in;  //inner cls object
out=new OuterCls();
in=new OuterCls().new InnerCls();
out.f1();
in.f2();


	}

}
