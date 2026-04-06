// Q) Implement multi-level inheritance.

import java.util.*;
class A{
    void showA(){
        System.out.println("Class A");
    }
}
class B extends A{
    void showB(){
        System.out.println("Class B");
    }
}
class C extends B{
    void showC(){
        System.out.println("Class C");
    }
}
public class S11_Q1_MultilevelInheritance {
    public static void main(String[] args){
        C x = new C();
        x.showA();
        x.showB();
        x.showC();
    }
}

// // Output : 
// Class A
// Class B
// Class C