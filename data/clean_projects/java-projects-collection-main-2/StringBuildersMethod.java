public class StringBuildersMethod {
    public static void main(String args[]){
        // String Builder Max = 16
        StringBuilder x = new StringBuilder("Java");
        // String Builder Methods
        // Capacity
        System.out.println("Capacity : "+x.capacity());
        
        // length
        System.out.println(x.length());

        // append
        System.out.println("Append :"+x.append(" Programming"));
        
        // insert
        // javaprogramming
        x.insert(0, "max ");
        System.out.println(x);

        // delete
        x.delete(0, 3);
        System.out.println(x);

        // tostring
        String y = x.toString();

        // reverse
        System.out.println(x.reverse());

        // deletecharat
        x.deleteCharAt(7);
        System.out.println(y);

        // toString
        String s=x.toString();

        // reverse
        System.out.println(x.reverse());
    }
}
