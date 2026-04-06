    
//Correct code:
/**
 * Question Link: https://www.hackerrank.com/challenges/java-1d-array/problem 
 * Description:
 * You are playing a game on an array of integers. In each move, you can 
 * walk one step to the right, one step to the left, or make a leap of a 
 * given length. You start at the first position of the array (index 0). 
 * The goal of the game is to reach the end of the array (index n-1) or 
 * beyond. You can only move to a position if it contains a 0. If you land 
 * on a position containing a 1, you lose the game.
 * 
 * Given the game array and the length of the leap, determine if you can 
 * win the game.
 * 
 * Input Format:
 * The first line contains an integer q, the number of queries.
 * The next q sets of lines each start with an integer n, the length of 
 * the array, and an integer leap, the length of the leap. The next line 
 * contains n space-separated binary integers (0s and 1s) describing the 
 * game array.
 * 
 * Constraints:
 * 1 <= q <= 5000
 * 2 <= n <= 100
 * 0 <= leap <= 100
 * 0 <= game[i] <= 1, where 0 <= i < n
 * Output Format:
 * For each query, print YES on a new line if you can win the game; otherwise
 * , print NO.
 * 
Sample Input

STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO

Explanation:
In the first query, you can win the game by taking a leap of 3 from index 0 
to index 3, then walking one step to index 4.
In the second query , you can win the game by taking a leap of 5 from 
index 0 to index 5.
In the third query, there is no way to win the game. you must avoid landing 
on indices 2, 3, and 4 because they contain 1s.
In the fourth query, there is no way to win the game. You must avoid landing 
on index 1 because it contains a 1.

 */
import java.util.*;

public class firstNonDuplicateChar {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int i, prevIndex = 0;
        boolean flag = false;
        if(game.length >= 2 && game.length <= 100 &&  leap >= 0  && leap <= 100)
        for(i = 0; i < game.length;) 
        {
            if(game[i] == 0 && (i+1 == game.length || i+leap == game.length)) 
            {
                flag = true;
                break;
            }
            else if(i+leap < game.length  &&  game[i+leap] == 0)
            {
                prevIndex = i;
                i+=leap;
            }
            else if(i+1 < game.length &&  i+1 != prevIndex && game[i+1] == 0)
            {
                prevIndex = i;
                i++;
            }
            else if ( i-1 > 0 && i-1 != prevIndex &&  game[i-1]==0)
            {
                prevIndex  =  i;
                i  -= 1;
            }
            else break;
            
            if(prevIndex  == i) break;
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();     
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

