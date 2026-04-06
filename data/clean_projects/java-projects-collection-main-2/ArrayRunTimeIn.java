import java.util.*;
public class ArrayRunTimeIn {
    public static void main(String args[]){
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        char a[] = new char[n];
        for(int i = 0;i<n;i++) a[i] = x.next().charAt(0);
        for(char y:a) System.out.println(y+" ");
    }
}
