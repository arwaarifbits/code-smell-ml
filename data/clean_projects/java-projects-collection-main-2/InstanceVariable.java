class instaDemo {
    static int x = 10; // Static variable
    int y = 20; // Instance variable
    void show(){
        int z=30; // Local variable
        System.out.println("Static : "+x);
        System.out.println("Instance : "+y);
        System.out.println("Local : "+z);
    }
}

class InstanceVariable{
    public static void main(String args[]){
        instaDemo a = new instaDemo();
        a.show();
        instaDemo b = new instaDemo();
        b.y = 50;
        b.show();
    }
}