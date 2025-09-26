public class CatTester {
    public static void main(String[] args) {
        Cat myCat = new Cat("Betsy", "Tabby");// added new
        Cat otherCat = new Cat("Tiger Beast", "Tabby");// added new
        System.out.println(myCat.toString());
        System.out.println("My Cat's Name: " + myCat.getName());// added parenthesis and sout

        System.out.println("Are the cat's equal? " + myCat.equals(otherCat));// changed to print

        System.out.print("Is my cat hungry? " + myCat.getIsHungry());// added system.out

        String firstName = "Tiger";
        String lastName = "Beast";// removed equal
        String name = firstName + " " + lastName;

        System.out.println("Changing the cat's name...");
        myCat.setName(name);

        System.out.println("The two cat's are the same now: " + myCat.equals(otherCat));

    }

}
