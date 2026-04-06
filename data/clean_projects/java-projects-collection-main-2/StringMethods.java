import java.util.*;
public class StringMethods {
    public static void main(String args[]){
        String a = "Java Programming";
        String b = "Python Programming";
        String c = "JAVA PROGRAMMING";
        String d = "   Python Programming ";
        String e = "Java is Fun, Java is powerful lauguage";
        
        // length() = Returns number of characters.
        System.out.println(a.length());

        // charAt(index) = Gets character at a position.
        System.out.println(b.charAt(0));

        // indexOf() = Gives first occurrence index.
        System.out.println(a.indexOf('P'));

        // lastIndexOf() = Last occurrence.
        System.out.println(a.lastIndexOf('a'));

        // substring(start, end) = Extracts part of string.
        System.out.println(c.substring(0,4));

        // equals() = Checks exact equality.
        System.out.println(a.equals(a));

        // equalsIgnoreCase() = Ignores uppercase/lowercase.
        System.out.println(a.equalsIgnoreCase(c));

        // replace(old, new) = it is used to replace in string
        System.out.println(a.replace('j','a'));

        // toLowerCase()  = it converts into lower case
        System.out.println(c.toLowerCase());

        // toUpperCase() = it converts into upper case
        System.out.println(a.toUpperCase());

        // trim() = Removes spaces from start & end.
        System.out.println(d.trim());

        // contains() = Checks if text exists inside string.
        System.out.println(a.contains("Pro"));

        // compareTo() = Compares 2 strings lexicographically.
        System.out.println(a.compareTo(c));

        // split() = Breaks string into an array.
        System.out.println(Arrays.toString(e.split(" ")));

        // concat  = used to add two strings
        System.out.println(a.concat(a));

        // isempty = to check if string is empty or not
        System.out.println(a.isEmpty());
    }
}
