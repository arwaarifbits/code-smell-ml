import java.lang.*;
public class Strings {
    public static void main(String args[]){
        String x = "Java";
        String y = "Java";
        String z = new String("Java");
        // "==" checks adress
        System.out.println(x==y); // true because they will store in same location
        System.out.println(x==z); // false because z will store in different location
        // using equal method
        // equal checks the values
        System.out.println(x.equals(y)); 
        System.out.println(x.equals(z));
        // concat = is useed to add both the strings
        System.out.println(x.concat(y));
        x = x.concat(y);
        System.out.println(x);
    }
}
