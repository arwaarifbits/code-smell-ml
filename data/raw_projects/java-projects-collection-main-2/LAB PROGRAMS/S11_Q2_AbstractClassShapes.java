// Q) Find the areas of diƯerent shapes using abstract classes. 

import java.util.*;
abstract class Shape{
    abstract void area();
}
class Circle extends Shape{
    double r = 5;
    void area(){
        System.out.println("Circle Area : "+(Math.PI*r*r));
    }
}
class Rectangle extends Shape{
    int l = 4, b = 6;
    void area(){
        System.out.println("Rectangle Area : "+(l*b));
    }
}
class Triangle extends Shape{
    int b = 4,h=5;
    void area(){
        System.out.println("Triangle Area : "+(0.5*b*h));
    }
}
public class S11_Q2_AbstractClassShapes {
    public static void main(String[] args){
        Shape s;
        s = new Circle();
        s.area();

        s = new Rectangle();
        s.area();
    }
}
