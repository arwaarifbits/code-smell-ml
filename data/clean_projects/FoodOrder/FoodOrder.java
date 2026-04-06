
public class FoodOrder {
	int oid;
	String oname;
	int qty;
	float price;
	//assign values using constructors
	FoodOrder(){
		oid=101;
		oname="biryani";
		qty=2;
		price=600;
		
	}
	//display using functional method
	void f1() {
		System.out.println("Order details:");
		System.out.println("Order ID:" +oid);
		System.out.println("Order Name:" +oname);
		System.out.println("Quantity:" +qty);
		System.out.println("price:" +price);
		
		
	}
	
}
