
public class ObjectCls {
	int a;
ObjectCls(int x){ // para cons
	a = x;
	
}
ObjectCls(ObjectCls b){ // copy cons
	System.out.println("copy cons val is:" +b.a);
}

}
