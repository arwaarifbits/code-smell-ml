package LearningMethods;

public class ConvertIntToString {
        public static void main(String[] args) {
            int number = 12345; // Replace this with your integer

            // Convert the integer to a string
            String numberAsString = Integer.toString(number);

            // Extract the first character (which is the first digit)
            char firstDigit = numberAsString.charAt(0);

            // Convert the character back to an integer if needed
            int firstDigitAsInt = Character.getNumericValue(firstDigit);

            System.out.println("The first digit is: " + firstDigitAsInt);
        }
    }


