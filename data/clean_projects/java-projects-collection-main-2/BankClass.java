class Bank{
    long AN;
    String Name;
    Float Balance;
    void deposit(float amount){
        Balance += amount;
        System.out.println("Amount Added successfully");
        System.out.println();
    }
    void withdraw(float amount){
        if(Balance < amount){
            System.out.println("Infficient Amount");
            System.out.println();
        }
        else{
            Balance -= amount;
            System.out.println("Amount withdraw successfully");
            System.out.println();
        }
    }
    void display(){
        System.out.println("// Account Details \\");
        System.out.println("Account Number : "+AN);
        System.out.println("Name : "+Name);
        System.out.println("Balance : "+Balance);
        System.out.println();
    }
}

public class BankClass {
    public static void main(String args[]){
        Bank s1 = new Bank();
        s1.AN = 53565652;
        s1.Name = "Royaa";
        s1.Balance = 10000.0f;
        s1.display();
        s1.deposit(1000);
        s1.withdraw(30000);
        s1.display();
    }
}
