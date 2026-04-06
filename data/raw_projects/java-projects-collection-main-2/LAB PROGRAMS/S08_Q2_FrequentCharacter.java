// Q) Find the most frequently occurring character in a string. 

import java.util.*;
public class S08_Q2_FrequentCharacter {
    public static void main(String[] args){
        String x = "programming";
        HashMap<Character,Integer> y = new HashMap<>();
        for(char c:x.toCharArray()) y.put(c,y.getOrDefault(c,0)+1);
        char mc = ' ';
        int mx = 0;
        for(Map.Entry<Character,Integer> e : y.entrySet()){
            if(e.getValue() > mx){
                mx = e.getValue();
                mc = e.getKey();
            }
        }
        System.out.println("Character: " + mc + " Frequency: " + mx);
    }
}
// OutPut : 
// Character: r Frequency: 2