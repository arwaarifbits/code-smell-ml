// Q) Find the most frequently occurring character in a string. 

import java.util.*;
public class S09_Q1_Pangram {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        String y = x.nextLine();
        y = y.toLowerCase();

        boolean[] z = new boolean[26];
        for(char c:y.toCharArray()){
            if(c>='a' && c <= 'z') z[c-'a'] = true;
        }
        boolean P = true;
        for(boolean b:z){
            if(!b){
                P = false;
                break;
            }
        }
        if(P) System.out.println("Pangram");
        else System.out.println("Not Pangram");
    }
}

// // Input:
// The quick brown fox jumps over the lazy dog

// // Output : 
// Pangram