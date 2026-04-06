// Q) Implement constructor and constructor overloading. 

import java.util.*;
class Demo{
    int x;
    String name;
    Demo(){
        x=0;
        name = "Default";
    }
    Demo(int x){
        this.x = x;
        name = "Default";
    }
    Demo(int x,String name){
        this.x = x;
        this.name = name;
    }
    void display(){
        System.out.println(x + " "+ name);
    }
}
public class S07_Q1_Constructors {
    public static void main(String[] args){
        Demo a = new Demo();
        Demo b = new Demo(10);
        Demo c = new Demo(10,"Chowdary");
        a.display();
        b.display();
        c.display();
    }
}

// Output : 
// 0 Default
// 10 Default
// 10 Chowdary