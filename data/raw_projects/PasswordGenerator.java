import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordGenerator {
    public static void main(String[] args) {
        SecureRandom rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String upper  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*";
        String allChars = lower + upper + nums + special;
        int numsIdx = rnd.nextInt(nums.length());
        pass.append(nums.charAt(numsIdx));
        int upperIdx = rnd.nextInt(upper.length());
        pass.append(upper.charAt(upperIdx));
        int specialIdx = rnd.nextInt(special.length());
        pass.append(special.charAt(specialIdx));
        for(int i = 0; i<8 ; i++){
            int idx = rnd.nextInt(allChars.length());
            pass.append(allChars.charAt(idx));
        }
        String passString = pass.toString();

        List<Character> list = new ArrayList<>();
        for(char c : passString.toCharArray()){
            list.add(c);
        }
        Collections.shuffle(list);
        String finalPass = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(finalPass);
    }
}
