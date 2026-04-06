import java.util.Scanner;

class Add{
    static int add(int a,int b){
        return a+b;
    }
}
public class StaticMethods {
    public static void main(String args[]){
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        int b = x.nextInt();
        int r = Add.add(a,b);
        System.out.println("Result : "+r);
    }
}
