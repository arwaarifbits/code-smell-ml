// Q) Implement method overloading. 

import java.util.*;
class Demo{
    void add(int a,int b){
        System.out.println(a+b);
    }
    void add(int a,int b,int c){
        System.out.println(a+b+c);
    }
    void add(double a,double b){
        System.out.println(a+b);
    }
}
public class S08_Q1_MethodOverloading {
    public static void main(String[] args){
        Demo x = new Demo();
        x.add(10,20);
        x.add(10,20,30);
        x.add(2.5,2.5);
    }
}

// OutPut : 
// 30
// 60
// 5.0