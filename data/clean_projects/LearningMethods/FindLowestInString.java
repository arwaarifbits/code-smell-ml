package LearningMethods;

public class FindLowestInString {
    public static void main(String[] args) {
        String numbersString = "5 3 8 1 7"; // Replace this with your input string of numbers
        String[] numberArray = numbersString.split(" "); // Split the string by spaces
        int minNumber = Integer.MAX_VALUE; // Initialize minNumber to a large value

        for (String numStr : numberArray) {
            int num = Integer.parseInt(numStr); // Convert each number string to an integer
            if (num < minNumber) {
                minNumber = num; // Update minNumber if a smaller number is found
            }
        }

        System.out.println("The lowest number is: " + minNumber);
    }
}

