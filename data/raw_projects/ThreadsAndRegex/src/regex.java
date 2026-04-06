import java.util.regex.*;

public class regex{
    public static void main(String[] args) {

        // ================================
        // 1. BASIC PATTERN & MATCHER
        // ================================
        System.out.println("1. BASIC MATCHING");

        String text = "Hello Java World";
        Pattern p1 = Pattern.compile("Java");   // what to find
        Matcher m1 = p1.matcher(text);

        System.out.println("Found 'Java'? " + m1.find());


        // ================================
        // 2. CHARACTER CLASSES
        // ================================
        System.out.println("\n2. CHARACTER CLASSES");

        String cl = "a7 b3 c9 Z5";
        Pattern p2 = Pattern.compile("[a-z][0-9]"); // letter+digit
        Matcher m2 = p2.matcher(cl);

        while (m2.find()) {
            System.out.println("Match: " + m2.group());
        }


        // ================================
        // 3. QUANTIFIERS (*, +, ?, {n})
        // ================================
        System.out.println("\n3. QUANTIFIERS");

        String q = "Hello";
        Pattern p3 = Pattern.compile("o+"); // one or more O's
        Matcher m3 = p3.matcher(q);

        while (m3.find()) {
            System.out.println("o+ found: " + m3.group());
        }


        // ================================
        // 4. GREEDY vs LAZY QUANTIFIERS
        // ================================
        System.out.println("\n4. GREEDY vs LAZY");

        String gl = "<tag>Something</tag><tag>Else</tag>";

        // Greedy: grabs the largest possible
        Pattern greedy = Pattern.compile("<tag>.*</tag>");
        Matcher mg = greedy.matcher(gl);
        if (mg.find()) {
            System.out.println("Greedy: " + mg.group());
        }

        // Lazy: grabs the smallest possible
        Pattern lazy = Pattern.compile("<tag>.*?</tag>");
        Matcher ml = lazy.matcher(gl);
        while (ml.find()) {
            System.out.println("Lazy:   " + ml.group());
        }


        // ================================
        // 5. GROUPS ( )
        // ================================
        System.out.println("\n5. GROUPS ( )");

        String groups = "Name: Angelique Age: 17";
        Pattern p5 = Pattern.compile("Name: (\\w+) Age: (\\d+)");
        Matcher m5 = p5.matcher(groups);

        if (m5.find()) {
            System.out.println("Group 1 (Name): " + m5.group(1));
            System.out.println("Group 2 (Age): " + m5.group(2));
        }


        // ================================
        // 6. BACKREFERENCES
        // ================================
        System.out.println("\n6. BACKREFERENCES");

        String br = "cat dog dog cat cat dog";
        Pattern p6 = Pattern.compile("(dog) \\1"); // "dog dog"
        Matcher m6 = p6.matcher(br);

        while (m6.find()) {
            System.out.println("Backreference match: " + m6.group());
        }


        // ================================
        // 7. BOUNDARIES (\b, ^, $)
        // ================================
        System.out.println("\n7. BOUNDARIES");

        String bd = "Hello world! Welcome to the world.";
        Pattern p7 = Pattern.compile("\\bworld\\b");
        Matcher m7 = p7.matcher(bd);

        while (m7.find()) {
            System.out.println("Whole word: " + m7.group());
        }


        // ================================
        // 8. REPLACING USING REGEX
        // ================================
        System.out.println("\n8. REPLACING");

        String rep = "I love Java. Java is powerful.";
        String replaced = rep.replaceAll("Java", "Python");
        System.out.println(replaced);


        // ================================
        // 9. SIMPLE EMAIL VALIDATION
        // ================================
        System.out.println("\n9. EMAIL VALIDATION");

        String email = "nziza@example.com";
        Pattern p9 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
        Matcher m9 = p9.matcher(email);

        System.out.println("Valid email? " + m9.matches());


        // ================================
        // 10. SIMPLE NAME VALIDATION
        // ================================
        System.out.println("\n10. NAME VALIDATION");

        String name = "Angelique Nziza";
        Pattern p10 = Pattern.compile("^[A-Za-z ]{3,}$");
        Matcher m10 = p10.matcher(name);

        System.out.println("Valid name? " + m10.matches());
    }
}
