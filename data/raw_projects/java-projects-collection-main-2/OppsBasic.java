class Student{
    int rollNo;
    String name;
    String Branch;
    void Write(){
        System.out.println("A student can read");
    }
    void display(){
        System.out.println("Roll Number : "+rollNo);
        System.out.println("Name : "+name);
        System.out.println("Branch : "+Branch);
    }
}
public class OppsBasic {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.rollNo = 31;
        s1.name = "Suri";
        s1.Branch = "AIML";
        s1.display();
    }
}