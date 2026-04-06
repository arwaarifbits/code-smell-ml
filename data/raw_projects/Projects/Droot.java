package Projects;

//takes an integer and sum's all the digits until a single digit is left
public class Droot {
    public static void main(String[] args) {
        digital_root(156);
    }
    public static void digital_root(int n) {

        do {
            int x;
            int y=0;
            int lengthN = String.valueOf(n).length();

            int[] array = new int[lengthN];

            for (int i = 0; i < lengthN; i++) {
                x = Integer.parseInt(String.valueOf(String.valueOf(n).charAt(i)));
                array[i] = x;
            }
            if (array.length > 1) {
                for (int j : array) {
                    y += j;
                }
                n = y;
            }

        }while (n>9);

        System.out.println(n);
    }
}
