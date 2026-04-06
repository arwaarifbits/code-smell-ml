// Q) Check if a given string is an anagram (Example: CAT and ACT). 

import java.util.*;
public class S10_Q1_Anagram {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        String y = x.nextLine();
        String z = x.nextLine();
        
        char[] a = y.toCharArray();
        char[] b = z.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if(Arrays.equals(a,b)) System.out.println("Anagram");
        else System.out.println("Not Anagram");
    }
}

// // Input :
// cat
// act

// // Output : 
// Anagram