// Q) Write a Java program to create a HashMap that stores Student ID and Name. Insert at least five records and display them using entrySet() and an Iterator. Repeat the same using a TreeMap. 


import java.util.*;
public class S01_Q2_HashMap_TreeMap {
    public static void main(String[] args){
        System.out.println("Hash MAP : ");
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(101,"A");
        hm.put(102,"B");
        hm.put(103,"C");
        hm.put(104,"D");
        hm.put(105,"E");
        Iterator<Map.Entry<Integer,String>> it1 = hm.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry<Integer,String> e = it1.next();
            System.out.println(e.getKey()+" "+e.getValue());
        }

        System.out.println("\nTree MAP : ");
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(101,"A");
        tm.put(102,"B");
        tm.put(103,"C");
        tm.put(104,"D");
        tm.put(105,"E");
        Iterator<Map.Entry<Integer,String>> it2 = tm.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry<Integer,String> e = it2.next();
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
