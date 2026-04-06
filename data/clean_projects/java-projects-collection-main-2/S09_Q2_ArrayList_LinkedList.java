// Q) Write a Java program to create an ArrayList and a LinkedList, add at least five elements, and display them using an Iterator. Demonstrate two methods such as add(), remove(), get() or size().

import java.util.*;
public class S09_Q2_ArrayList_LinkedList {
    public static void main(String[] args){
        ArrayList<Integer> x = new ArrayList<>();
        x.add(10);
        x.add(20);
        x.add(30);
        x.add(40);
        x.add(50);
        System.out.println("ArrayList : ");
        Iterator<Integer> it1 = x.iterator();
        while(it1.hasNext()) System.out.print(it1.next()+" ");
        System.out.println("\nSize : "+x.size());
        System.out.println("Element at Index 2 : "+x.get(2));
        x.remove(1);

        LinkedList<Integer> y = new LinkedList<>();
        y.add(100);
        y.add(200);
        y.add(300);
        y.add(400);
        y.add(500);
        System.out.println("LindedList : ");
        Iterator<Integer> it2 = y.iterator();
        while(it2.hasNext()) System.out.print(it2.next()+" ");
        System.out.println("\nSize : "+y.size());
        System.out.println("Element at Index 2 : "+y.get(2));
        y.remove(1);
    }
}

// Output : 
// ArrayList : 
// 10 20 30 40 50 
// Size : 5
// Element at Index 2 : 30
// LindedList :
// 100 200 300 400 500
// Size : 5
// Element at Index 2 : 300