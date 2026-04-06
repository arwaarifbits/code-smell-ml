// Q) Display the details of a person. Personal details should be given in one method and qualification details in another method.

import java.util.*;
public class S06_Q1_PersonDetails {
    void P(){
        System.out.println("Name : Chowdary");
        System.out.println("Age : 18");
    }
    void Q(){
        System.out.println("Degree : B.Tech");
        System.out.println("Branch: AIML");
    }
    public static void main(String[] args){
        S06_Q1_PersonDetails x = new S06_Q1_PersonDetails();
        x.P();
        x.Q();
    }
}

// // OutPut:
// Name : Chowdary
// Age : 18
// Degree : B.Tech
// Branch: AIML