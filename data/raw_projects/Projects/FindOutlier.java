package Projects;

//It counts the number of even and odd integers in the input array
// using the variables numEvens and numOdds.
public class FindOutlier {
    static int find(int[] integers) {
        int numEvens = 0;
        int numOdds = 0;

        // Count the number of even and odd integers
        for (int x : integers) {
            if (x % 2 == 0) {
                numEvens++;
            } else {
                numOdds++;
            }
        }

        // Determine the outlier based on the majority
        for (int x : integers) {
            if ((numEvens > numOdds && x % 2 != 0) || (numOdds > numEvens && x % 2 == 0)) {
                return x;
            }
        }

        return 0; // Default return value if no outlier is found
    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 8, 9, 3}; // Example array
        int outlier = find(numbers);
        System.out.println("The outlier is: " + outlier);
    }
}
