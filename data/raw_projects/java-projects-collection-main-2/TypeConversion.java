public class TypeConversion {
    public static void main(String args[]){
        // Widening ==> small to high datatype
        // byte->short->char->int->long->float->double
        int x=20;
        float y = x;
        System.out.println(y);

        //Narrowing ==> higher to small datatype
        // byte<-short<-char<-int<-long<-float<-double
        float a = 352.652f;
        int b = (int)a;
        System.out.println(b);
    }
}
