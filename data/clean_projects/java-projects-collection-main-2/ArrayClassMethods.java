import java.util.*;
public class ArrayClassMethods {
    public static void main(String args[]){
        int x[] = {56,21,48,32,69,78,92,54,10,23};
        // convert int to String 
        System.out.println(Arrays.toString(x));
        //  to sort an array
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
            // to sort from start to end
        int y[] = {56,21,48,32,69,78,92,54,10,23};
        Arrays.sort(y,0,5);
        System.out.println(Arrays.toString(y));
        // to copy an array
        int c[] = Arrays.copyOf(y,10);
        System.out.println(Arrays.toString(c));
        // to Search a Particular element using binary Search
        System.out.println(Arrays.binarySearch(x,92));
        // to check if the two arrays is equal or not it give boolen values
        System.out.println(Arrays.equals(x,y));
    }    
}
