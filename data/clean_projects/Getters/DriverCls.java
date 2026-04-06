
public class DriverCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
CustomerDetails c;
c=new CustomerDetails();//encapsulation
//assign values to class variables
c.Cust_Id=101;
c.Cust_Name="abc";
c.Cust_MNumber=12345;
c.Cust_Addr="Khammam";
//display values using getters
System.out.println("Customer Details......");
System.out.println("Cust ID :"+c.getCust_Id());
System.out.println("Cust Name :"+c.getCust_Name());
System.out.println("Cust MNumber :"+c.getCust_MNumber());
System.out.println("Cust Addr :"+c.getCust_Addr());
	}
}
