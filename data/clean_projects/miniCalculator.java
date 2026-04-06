import java.util.*;

public class miniCalculator {
    public static void main(String[] args){
       Scanner bleh = new Scanner(System.in);
       String ch;
       do{
           System.out.print("Enter your two numbers:");
           int a = bleh.nextInt();
           int b = bleh.nextInt();
           System.out.println("    MINI CALCULATOR");
           System.out.println("1:ADDITION");
           System.out.println("2:SUBTRACTION");
           System.out.println("3:MULTIPLICATION");
           System.out.println("4:DIVISION");
           System.out.print("SELECT YOUR OPERATION:");
           int num = bleh.nextInt();
           switch (num){
               case 1:
                   int sum = a + b;
                   System.out.println("The sum of your numbers is "+sum);
                   break;
               case 2:
                   int diff = a-b;
                   System.out.println("The difference of your numbers is "+diff);
                   break;
               case 3:
                   int product = a*b;
                   System.out.println("The product of your numbers is "+product);
                   break;
               case 4:
                   if(b!=0){
                       int ans = a/b;
                       System.out.println("The quotient is "+ans);
                   }else{
                       System.out.println("Cannot divide by zero");
                   }
                   break;
               default:
                   System.out.println("INVALID OPERATION");
           }
           System.out.print("Do you wanna use the calculator again(Y/N):");
           String choice = bleh.next();
           ch = choice.toUpperCase();
       }while(ch.equals("Y"));
        System.out.println("THANK YOU FOR USING THIS CALCULATOR");
    }
}
