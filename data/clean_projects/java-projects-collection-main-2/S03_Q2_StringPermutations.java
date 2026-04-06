// Q) Find all permutations of a given string. 

import java.util.*;
public class S03_Q2_StringPermutations {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        String n = x.nextLine();
        P(n,"");
    }
    static void  P(String n,String ans){
        if(n.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<n.length();i++){
            char c = n.charAt(i);
            String r = n.substring(0,i)+n.substring(i+1);
            P(r,ans+c);
        }
    }
}

// OUTPUT : 
// ABC
// ACB
// BAC
// BCA
// CAB
// CBA