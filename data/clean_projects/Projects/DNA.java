package Projects;

//replaces the given characters with the ones below.The pairing stems from the DNA
public class DNA {
    public static void main(String[] args) {
        replaceWords("TACGATTG");
    }

    public static void replaceWords(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);
            if (currentChar == 'A') {
                stringBuilder.setCharAt(i, 'T');
            } else if (currentChar == 'C') {
                stringBuilder.setCharAt(i, 'G');
            } else if (currentChar == 'T') {
                stringBuilder.setCharAt(i, 'A');
            } else if (currentChar == 'G') {
                stringBuilder.setCharAt(i, 'C');

            }
        }
        String replacedString = stringBuilder.toString();
        System.out.println("Original String: " + text);
        System.out.println("Replaced String: " + replacedString);
    }
}