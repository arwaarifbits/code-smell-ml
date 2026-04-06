// Q) Write a Java program to create a Hashtable to store Employee ID and Employee Name. Insert at least five records and display them using an Iterator.

import java.util.*;
public class S05_Q2_Hashtable {
    public static void main(String[] args){
        Hashtable<Integer,String> x = new Hashtable<>();
        x.put(101, "A");
        x.put(102, "B");
        x.put(103, "C");
        x.put(104, "D");
        x.put(105, "E");
        Iterator<Map.Entry<Integer,String>> y = x.entrySet().iterator();
        while(y.hasNext()){
            Map.Entry<Integer,String> e = y.next();
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}

// Output : 
// 105 E
// 104 D
// 103 C
// 102 B
// 101 A