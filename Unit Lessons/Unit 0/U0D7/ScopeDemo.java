public class ScopeDemo {
    private String world = "World";

    public static void main(String[] args) {
        ScopeDemo demo = new ScopeDemo();
        System.out.println(demo.method2());
    }

    public String method2() {
        String hello = "Hello";
        String goodbye = "";
        if (true) {
            goodbye = "Goodbye";
        }
        System.out.println(goodbye);

        return hello;
    }

    public String method1() {
        return method2() + world;
    }
}
