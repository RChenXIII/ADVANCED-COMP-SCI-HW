import java.util.ArrayList;

public class Shelter {
    // instance variables
    private Dog[][] kennels;

    // constructors
    public Shelter(int rows, int cols) {
        // to-do: implement this constructor
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException(
                    "Rows and Cols cannot be less than or equal to zero.");
        }
        kennels = new Dog[rows][cols];
    }

    /* initializes kennels as a 3x3 2D array */
    public Shelter() {
        kennels = new Dog[3][3];
    }

    // getters and setters
    public Dog[][] getKennels() {
        return kennels;
    }

    public void setKennels(Dog[][] kennels) {
        this.kennels = kennels;
    }

    // methods

    public void displayStatus() {
        for (Dog[] row : kennels) {
            for (Dog animal : row) {
                if (animal != null) {
                    System.out.print(animal);
                } else {
                    System.out.print("[Empty]");
                }
            }
            System.out.println();
        }
    }

    public void add(Dog animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null.");
        }
        for (int i = 0; i < kennels.length; i++) {
            for (int j = 0; j < kennels[i].length; j++) {
                if (kennels[i][j] == null) {
                    kennels[i][j] = animal;
                    return;
                }
            }
        }
        System.out.println("No empty kennels.");
    }

    public void add(Dog animal, int row, int col) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null.");
        }
        if (row < 0 || row >= kennels.length || col < 0 || col >= kennels[0].length) {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
        if (kennels[row][col] == null) {
            kennels[row][col] = animal;
        } else {
            add(animal);
        }
    }

    public void add(ArrayList<Dog> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Animal list cannot be null.");
        }
        for (Dog dog : animals) {
            if (dog == null) {
                throw new IllegalArgumentException("Animal cannot be null.");
            }
            add(dog);
        }
    }


    public Dog adopt(int row, int col) {
        if (row < 0 || row >= kennels.length || col < 0 || col >= kennels[0].length) {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
        if (kennels[row][col] == null) {
            throw new IllegalArgumentException("No dog at this location.");
        }
        Dog dog = kennels[row][col];
        kennels[row][col] = null;
        return dog;
    }

    public ArrayList<Dog> search(String name) {
        ArrayList<Dog> results = new ArrayList<Dog>();
        for (Dog[] row : kennels) {
            for (Dog dog : row) {
                if (dog != null && dog.getName().equals(name)) {
                    results.add(dog);
                }
            }
        }
        return results;
    }

    public ArrayList<Dog> search(int age) {
        ArrayList<Dog> results = new ArrayList<Dog>();
        for (Dog[] row : kennels) {
            for (Dog dog : row) {
                if (dog != null && dog.getAge() == age) {
                    results.add(dog);
                }
            }
        }
        return results;
    }
}

