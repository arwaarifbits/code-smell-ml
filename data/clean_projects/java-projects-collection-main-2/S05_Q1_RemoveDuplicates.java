// Q) Remove duplicate elements from an array

import java.util.*;
public class S05_Q1_RemoveDuplicates {
    public static void main(String[] args){
        int[] x = {10,10,20,10,20,30,40,10};
        Set<Integer> y = new LinkedHashSet<>();
        for(int i:x) y.add(i);
        for(int i:y) System.out.print(i+" ");
    }
}

// Output : 
// 10 20 30 40