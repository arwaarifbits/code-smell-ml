package Projects;
//finds the square root of every digit in the given integer and prints them
public class SquareDigit {
    public static void main(String[] args) {
        squareDigits(567);
    }

    public static void squareDigits(int n) {
        int nums = String.valueOf(n).length();
        String numberAsString = Integer.toString(n);//changes the Integer into a String
        StringBuilder x = new StringBuilder();//we call the StringBuilder class for x
        for (int i = 0; i < nums; i++) {
            char firstDigit = numberAsString.charAt(i);
            int firstDigitAsInt = Character.getNumericValue(firstDigit);
            firstDigitAsInt *= firstDigitAsInt;//we multiply the digit by itself
            x.append(firstDigitAsInt);//x takes the value
        }

        int y = Integer.parseInt(x.toString());
        System.out.println(y);
    }
}
