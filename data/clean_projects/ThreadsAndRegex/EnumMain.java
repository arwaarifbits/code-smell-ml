import java.lang.Enum;
import java.util.Scanner;

public class EnumMain {
    enum Gender{
      FEMALE,
        MALE
    }
    public  static void main(String[] args){
              Scanner s = new Scanner(System.in);
              System.out.println("Enter your Gender:");
              String gen = s.nextLine().toUpperCase();

              Gender gender = Gender.valueOf(gen);

              if(gender == Gender.FEMALE) {
                  System.out.println("You are a girl");
              }else if (gender == Gender.MALE) {
                  System.out.println("You are a boy");
              }
         s.close();
        }
    }
    
