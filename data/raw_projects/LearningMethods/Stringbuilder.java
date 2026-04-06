package LearningMethods;

public class Stringbuilder {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        StringBuilder stringBuilder = new StringBuilder(originalString);

        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);
            if (currentChar == 'o') {
                stringBuilder.setCharAt(i, 'X');
            }
            // Add more conditions and replacements as needed
        }

        String replacedString = stringBuilder.toString();
        System.out.println("Original String: " + originalString);
        System.out.println("Replaced String: " + replacedString);
    }
}
