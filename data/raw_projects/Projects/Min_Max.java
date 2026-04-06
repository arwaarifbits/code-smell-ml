package Projects;

import java.util.Arrays;
import java.util.Scanner;

public class Min_Max {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] nums;
        System.out.println("enter number of integers ");
        int n = scanner.nextInt();
        nums = new int[n];
        setNums(nums);
        Arrays.sort(nums);
        scanner.close();
        System.out.println("The min= " + nums[0]);
        System.out.println("The max= " + nums[nums.length - 1]);

    }

    public static void setNums(int[] array) {
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

        }
    }
}
