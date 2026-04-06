import java.util.*;
class RedingInput {
    public static void main(String arg[]){
        Scanner x = new Scanner(System.in);
        System.out.println("Enter The Input : ");

        // input from user
        byte a = x.nextByte();
        short b = x.nextShort();
        int c = x.nextInt();
        long d = x.nextLong();
        double e = x.nextDouble();
        float f = x.nextFloat();
        char g = x.next().charAt(0);
        String h = x.next();
        x.nextLine();
        String i = x.nextLine();

        System.out.println();
        System.out.println("GIVEN INPUTS : ");
        // Printing all the inputs to user
        System.out.println("Byte : "+a);
        System.out.println("Short : "+b);
        System.out.println("Int : "+c);
        System.out.println("Long : "+d);
        System.out.println("Double : "+e);
        System.out.println("Float : "+f);
        System.out.println("Char : "+g);
        System.out.println("String : "+h);
        System.out.println("Sentance : "+i);
    }
}