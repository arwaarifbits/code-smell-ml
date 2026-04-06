// Q) Find the maximum and minimum element in an array. 

import java.util.*;
public class S04_Q1_MaxMinArray {
    public static void main(String[] args){
    int[] x = {10,5,32,54,21,87,96};
    int mx = x[0],mn = x[0];
    for(int i:x){
        if(i>mx) mx = i;
        if(i<mn) mn = i;
    }
    System.out.println("Max Element : "+mx);
    System.out.println("Min Element : "+mn);
    }
}

// // Output : 
// Max Element : 96
// Min Element : 5