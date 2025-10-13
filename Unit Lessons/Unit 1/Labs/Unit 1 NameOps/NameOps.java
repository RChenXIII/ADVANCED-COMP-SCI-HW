public class NameOps {

    public static String printMethodCall(String method, String name) {
        return method + "(\"" + name + "\"): ";
    }

    public static String whoIsAwesome(String name) {
        return name + " is awesome!";
    }

    public static int indexOfFirstSpace(String name) {
        return name.indexOf(" ");
    }

    public static int indexOfSecondSpace(String name) {
        int firstSpace = indexOfFirstSpace(name);

        if (firstSpace == -1) {
            return -1;
        }

        return name.indexOf(" ", firstSpace + 1);
    }


    public static String findFirstName(String name) {
        int firstSpace = indexOfFirstSpace(name);

        if (firstSpace == -1) {
            return name;
        }

        return name.substring(0, firstSpace);
    }


    public static String findLastName(String name) {
        int firstSpace = indexOfFirstSpace(name);
        int secondSpace = indexOfSecondSpace(name);

        if (firstSpace == -1) {
            return "";
        }

        if (secondSpace != -1) {
            return name.substring(secondSpace + 1);
        }

        return name.substring(firstSpace + 1);
    }


    public static String findMiddleName(String name) {
        int firstSpace = indexOfFirstSpace(name);
        int secondSpace = indexOfSecondSpace(name);

        if (secondSpace == -1) {
            return "";
        }

        return name.substring(firstSpace + 1, secondSpace);
    }


    public static String generateLastFirstMidInitial(String name) {
        String firstName = findFirstName(name);
        String lastName = findLastName(name);
        String middleName = findMiddleName(name);


        if (lastName.length() == 0) {
            return name;
        }

        if (middleName.length() == 0) {
            return lastName + ", " + firstName;
        }

        char middleInitial = middleName.charAt(0);
        return lastName + ", " + firstName + " " + middleInitial + ".";
    }
}
