import Task1.*;
import Task2.*;
import Task3.*;
import java.util.Scanner;
public class DriverCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Task1.Customer c1;
c1=new Task1.Customer();

Task2.Customer c2;
c2=new Task2.Customer();

Task3.Customer c3;
c3=new Task3.Customer();
Scanner s;
s = new Scanner ( System.in );

System.out.println("************************************************************************");
System.out.println("Customer Details from task1 package");
System.out.println("************************************************************************");
System.out.println("input details for task1 package...");
System.out.println("Enter cust id");
c1.setCustid(s.nextInt());
System.out.println("Enter cust name");
c1.setCustname(s.next());
System.out.println("enter cust addr");
c1.setAddr(s.next());

System.out.println("************************************************************************");
System.out.println("Customer Details from task2 package");
System.out.println("************************************************************************");
System.out.println("input details for task2 package...");
System.out.println("Enter cust id");
c2.setCustid(s.nextInt());
System.out.println("Enter cust name");
c2.setCustname(s.next());
System.out.println("enter cust addr");
c2.setAddr(s.next());

System.out.println("************************************************************************");
System.out.println("Customer Details from task3 package");
System.out.println("************************************************************************");
System.out.println("input details for task3 package...");
System.out.println("Enter cust id");
c3.setCustid(s.nextInt());
System.out.println("Enter cust name");
c3.setCustname(s.next());
System.out.println("enter cust addr");
c3.setAddr(s.next());


	}

}
