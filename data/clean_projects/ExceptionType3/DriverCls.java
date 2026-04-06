
public class DriverCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int x=10;
try {
    System.out.println(x/2);
    int a[] = {10,20,30,40,50};
    try {
        System.out.println(a[3]);
    } 
    catch (Exception e1) {    // <-- this is the missing part
        System.out.println(e1);
    }
}
catch(Exception e) {
    System.out.println(e);
}
}
}