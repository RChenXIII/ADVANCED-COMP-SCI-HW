public class DogTester {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Justin", "Daniel", 5, 456);
        Dog dog2 = new Dog();
        Dog dog3 = new Dog("Owen", "Morgan", 7, 693);

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());

        dog1.setAge(dog1.getAge() + 1);
        dog2.setAge(dog2.getAge() + 1);

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog1.generateDogChar());
        System.out.println(dog2.generateDogChar());
        System.out.println(dog3.generateDogChar());
        System.out.println(dog1.generateDogTag());
        System.out.println(dog2.generateDogTag());

        System.out.println("dog1 equals dog2: " + dog1.equals(dog2));
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());


    }
}
