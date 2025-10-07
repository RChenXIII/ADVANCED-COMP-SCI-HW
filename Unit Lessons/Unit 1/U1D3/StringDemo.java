public class StringDemo {
    public static void main(String[] args) {
        // strings are objects
        String fullName = "Daniel Freidman";
        String fullName2 = "Daniel Freidman";

        System.out.println(fullName == fullName2);

        fullName2 = "Daniel A Freidman";
        String fullName3 = new String("Daniel Freidman");
        // Strings are immutable
        // fullName3 += ":)";

        System.out.println(fullName == fullName3);
        System.out.println(fullName.equals(fullName3));

        // charAt( -> returns the char value at index
        // Daniel Freidman
        System.out.println(fullName.charAt(3));
        // indexOf() -> returns the char value at index
        // Daniel Freidman

        System.out.println(fullName.indexOf("n"));

        // Daniel A Freidman
        System.out.println(fullName2.indexOf("n"));


        int firstSpace = fullName2.indexOf(" "); // finds first space
        String middleLastName = fullName2.substring(firstSpace); // creates a substring starting at
                                                                 // the first space to the end

        // A Friedman
        System.out.println(middleLastName.indexOf("n")); // find index of n


        String middleName = fullName2.substring(4, 13);


        System.out.println(middleName.indexOf("z"));

        String string1 = "abc";

        String string2 = "zzz";

        System.out.println(string1.compareTo(string2));

        // returns negative if abc is "before" abd
        // returns postive if abc is "after"
        // returns 0 if strings are equal

        System.out.println(string2.compareTo(string1));
    }
}
