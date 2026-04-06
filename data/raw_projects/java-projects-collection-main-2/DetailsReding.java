import java.util.*;
class DetailsReding {
    public static void main(String args[]){
        Scanner x = new Scanner(System.in);
        System.out.print("Enter The Roll Number : ");
        int a = x.nextInt();
        x.nextLine();
        System.out.print("Eneter The Name : ");
        String b = x.nextLine();
        System.out.print("Eneter The Branch : ");
        String c = x.nextLine();
        System.out.print("Eneter The Section : ");
        char d = x.next().charAt(0);
        System.out.print("Eneter The Att : ");
        float e = x.nextFloat();

        System.out.println("OUTPUT");
        System.out.println("Roll Number : "+a);
        System.out.println("Name : "+b);
        System.out.println("Branch : "+c);
        System.out.println("Section : "+d);
        System.out.println("Att : "+e);
    }
}
