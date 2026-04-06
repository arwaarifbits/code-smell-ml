package Projects;


//takes a String array comprised of digits that are separated by " "
public class highAndLow {
    public static void main(String[] args) {
        highandlow("1 2 3");
    }

    public static void highandlow(String numbers) {
        String[] numberArray = numbers.split(" "); // Split the string by spaces
        int minNumber = Integer.MAX_VALUE; // Initialize minNumber to a large value
        int maxNumber = Integer.MIN_VALUE;

        for (String numStr : numberArray) {
            int num = Integer.parseInt(numStr); // Convert each number string to an integer
            if (num < minNumber) {
                minNumber = num; // Update minNumber if a smaller number is found
            }
            if (num > maxNumber) {
                maxNumber = num;
            }


        }
        numbers = maxNumber + " " + minNumber;
        System.out.println(numbers);
    }
}
