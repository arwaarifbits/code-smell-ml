import java.util.*;

public class RandomNumber {
    public static void main(String[] args){
        Random random = new Random();
        //random number
        int num = random.nextInt(1,7);
        System.out.println(num);
        //coin toss
        boolean isHeads;
        isHeads = random.nextBoolean();
        if(isHeads){
            System.out.println("HEADS");
        }else{
            System.out.println("TAILS");
        }
        
    }
}
