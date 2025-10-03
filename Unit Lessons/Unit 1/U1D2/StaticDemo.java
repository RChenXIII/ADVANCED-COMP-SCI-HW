public class StaticDemo {
    public static void main(String[] args) {
        // if you have no constructor, I'll make a default fo you and assign all instance variables to their null state
        StaticDemo object = new StaticDemo();

        object.firstIfTest();


        // static methods
        // classes that hold static methods only are called helper classes
        String demo = StaticDemo.secondIfTest();

        // can print on the console without creating a System object
        System.out.println(demo);
    }

    // this method belongs fo object of the class
    public void firstIfTest() {
        int x = 4;
        int y = 3;
        int z = 4;

        if (x < y) {
            System.out.println("x is less than y");
        }
        if (x == z) {
            System.out.println("x is equal to z");
        }
    }

    // this method belongs to the class
    public static String secondIfTest() {
        int x = 4;
        int y = 3;
        int z = 4;

        if (x < y) {
            System.out.println("x is less than y");
        }
        if (x == z) {
            System.out.println("x is equal to z");
        }
        
        return "hello there";
    }
}