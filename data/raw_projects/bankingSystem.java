import java.util.Scanner;

public class bankingSystem {
    static Scanner bleh = new Scanner(System.in);
    public static void main(String[] args){
        //declaring variables
        double balance = 0;
        boolean isRunning = true;
        int choice;
        //MAIN LOOP FOR RUNNING THE BANK
        while(isRunning){
            System.out.println("***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");
            System.out.println("1.Show Balance");
            System.out.println("2.Deposit Money");
            System.out.println("3.Withdraw Money");
            System.out.println("4.EXIT");
            System.out.println("***************");

            System.out.print("Enter your choice (1-4): ");
            choice = bleh.nextInt();

            switch (choice){
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    balance += deposit();
                    showBalance(balance);
                    break;
                case 3:
                    balance -= withdraw(balance);
                    showBalance(balance);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice lil bro");
            }
        }
        for(int i=0;i<10;i++){
            System.out.println();
        }
        System.out.println("***********************************");
        System.out.println("THANKS FOR USING OUR BANKING SYSTEM");
        System.out.println("HOPE YOU HAVE A WONDERFUL DAY😊😊😊");
        System.out.println("***********************************");
        for(int i=0;i<10;i++){
            System.out.println();
        }
        bleh.close();
    }
    private static void showBalance(double  balance){
        System.out.println("***************");
        System.out.printf("Your balance is ₹%.2f\n",balance);
    }
    private static double deposit(){
        double depositAmount;
        System.out.print("Enter the amount you want to deposit:");
        depositAmount = bleh.nextDouble();
        if(depositAmount<0){
            System.out.println("Negative amount cannot be deposited ");
            return 0;
        }else{
            return depositAmount;
        }
    }
    private static double withdraw(double balance){
        double withdrawAmount;
        System.out.print("Enter the amount you want to withdraw:");
        withdrawAmount = bleh.nextDouble();
        if(withdrawAmount>balance){
            System.out.println("Insufficient Balance");
            return 0;
        }else if(withdrawAmount<0){
            System.out.println("Cannot withdraw negative amount");
            return 0;
        }else{
            return withdrawAmount;
        }
    }
}