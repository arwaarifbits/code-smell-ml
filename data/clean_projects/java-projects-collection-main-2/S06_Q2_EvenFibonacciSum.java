// Q) Find the sum of all even terms in the Fibonacci sequence up to the given range N. 

import java.util.*;
public class S06_Q2_EvenFibonacciSum {
    public static void main(String[] args){
        Scanner x =new Scanner(System.in);
        int n = x.nextInt(),a=0,b = 1,s = 0;
        while(a<=n){
            if((a&1) == 0) s += a;
            int c = a+b;
            a=b;
            b=c;
        }
        System.out.println(s);
        x.close();
    }
}
// Input : 10
// Output:
// 10