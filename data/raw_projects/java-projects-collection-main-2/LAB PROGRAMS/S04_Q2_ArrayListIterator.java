// Q) Write a Java program to create an ArrayList of integers, add elements, and traverse the list using an Iterator. 


import java.util.*;
public class S04_Q2_ArrayListIterator {
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
// OutPut : 
// 10 20 30 40 50 