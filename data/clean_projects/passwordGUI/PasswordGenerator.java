package passwordGUI;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_SYMBOLS = "!@#$%^&*";

    private final SecureRandom random;

    PasswordGenerator(){random = new SecureRandom();}

    public String generatePassword(int length , boolean includeUppercase , boolean includeLowercase , boolean includeNumbers ,
                                   boolean includeSpecialSymbols){
        StringBuilder passwordBuilder = new StringBuilder();
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        for(int i =0 ; i<length ; i++){
            int idx =  random.nextInt(validCharacters.length());

            char randomChar = validCharacters.charAt(idx);

            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();

    }
}
