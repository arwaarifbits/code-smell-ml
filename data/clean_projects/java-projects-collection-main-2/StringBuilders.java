
public class StringBuilders {
    public static void main(String srgs[]){
        StringBuilder x = new StringBuilder();
        System.out.println("Initial capacity:"+x.capacity());
        x.append("hkvjbhfkrggjkbgjdfbbfbwrjionvjbbfvhjfvfefhfhb");
        System.out.println("Length : "+x.length());
        System.out.println("New Capacity : "+x.capacity());

        System.out.println(".........................................");
        System.out.println();

        StringBuilder y = new StringBuilder("java");
        System.out.println("Length : "+y.length());
        // Capacity = initialcapacity + length
        // Capacity = 16 + 4 = 20
        System.out.println("Capacity : "+y.capacity());

    }   
}