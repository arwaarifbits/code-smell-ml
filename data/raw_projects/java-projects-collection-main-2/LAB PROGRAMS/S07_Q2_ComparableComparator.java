// Q) Write a Java program to create a Student class with attributes id and name. Sort the objects using Comparable (id) and Comparator (name).

import java.util.*;
class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compareTo(Student s) {
        return this.id - s.id;
    }
}
class NameComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
public class S07_Q2_ComparableComparator {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(3, "C"));
        list.add(new Student(1, "A"));
        list.add(new Student(2, "B"));

        Collections.sort(list);
        for (Student s : list)
            System.out.println(s.id + " " + s.name);

        Collections.sort(list, new NameComparator());
        for (Student s : list)
            System.out.println(s.id + " " + s.name);
    }
}

// OutPut :
// 1 A
// 2 B
// 3 C

// 1 A
// 2 B
// 3 C