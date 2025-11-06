public class ArrayDemo {
    public static void main(String[] args) {

        // Pokemon[] team = new Pokemon[6];
        // {0, 1, 2, 3, 4, 5} ordered set

        // team[3] = new Pokemon("Charizard");
        // {0, 1, 2, "Charizard", 4, 5}
        
        // Size 6 list max index 5
        // Pokemon[] box = new Pokemon[30];
        // Pokemon[] box2 = new Pokemon[30];
        
        int[] myFavoriteNumbers = new int[4];

        myFavoriteNumbers[0] = 4;
        myFavoriteNumbers[1] = 20;
        myFavoriteNumbers[2] = 111;
        myFavoriteNumbers[3] = 0;


        for (int i = 0; i < myFavoriteNumbers.length; i++) {
            System.out.println(myFavoriteNumbers[i]);
        }


        String[] beatles = {"John Lennon", "Paul McCartney", "Ringo Starr", null};

        for (int i = 0; i < beatles.length; i++) {
            System.out.println(beatles[i]);
        }
        String[] beatles2 = new String[5];
        for (int i = 0; i < beatles2.length; i++) {
            if (beatles[i] != null) {
            beatles2[i] = beatles[i];
            System.out.println(beatles[i].length());
            } else {
                System.out.println("This element is null");
            }
        }
    }
}
