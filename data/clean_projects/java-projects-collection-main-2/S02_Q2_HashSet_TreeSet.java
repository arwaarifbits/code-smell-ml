// Q) Write a Java program to create a HashSet and TreeSet, insert at least five elements, and display them using an Iterator. Show the diƯerence in ordering.

import java.util.*;
public class S02_Q2_HashSet_TreeSet {
    public static void main(String[] args){
        System.out.println("HashSet : "); 
        HashSet<Integer> hs = new HashSet<>();
        hs.add(50);
        hs.add(10);
        hs.add(30);
        hs.add(20);
        hs.add(40);
        Iterator<Integer> it1 = hs.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
        System.out.println("\nTreeSet : ");
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(20);
        ts.add(40);
        Iterator<Integer> it2 = ts.iterator();
        while(it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
    }
}
