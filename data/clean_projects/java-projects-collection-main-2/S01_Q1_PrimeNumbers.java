// Q) Select all the prime numbers within the range of 1 to 100
import java.util.*;
public class S01_Q1_PrimeNumbers{
    public static void main(String[] args){
        for(int i = 2;i<=100;i++){
            boolean p = true;
            for(int j = 2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    p = false;
                    break;
                }
            }
            if(p) System.out.print(i + " ");
        }
    }
}