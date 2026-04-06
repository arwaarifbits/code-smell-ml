package Projects;

import java.util.Arrays;

//Counts by x for n times
public class CountBy {
    public static void countBy(int x, int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = x * (i + 1);//the formula for the wanted outcome

        }
        System.out.println(Arrays.toString(array));//print the values
    }

    public static void main(String[] args) {
        countBy(2, 10);
    }
}
