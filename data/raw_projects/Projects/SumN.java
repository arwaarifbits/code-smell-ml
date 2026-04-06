package Projects;

import java.util.Scanner;
//Calculate the sum of N Ints
public class SumN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        while (N>0){
            sum+=N--;
        }
        System.out.println(sum);

    }
}
