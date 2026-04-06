// Q) Check whether a given number is Armstrong or not. 

import java.util.*;
public class S02_Q1_Armstrong {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int t =n,d=(int)Math.log10(n)+1,sum=0;
        while(t!=0){
            sum+=Math.pow((int)t%10,d);
            t/=10;
        }
        System.out.println((sum==n)?"Armstrong Number":"Not Armstrong Number");
    }
}
