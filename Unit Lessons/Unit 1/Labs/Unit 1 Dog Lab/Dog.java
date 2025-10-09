public class Dog {
    // Instance variables
    private String name;
    private String ownerName;
    private int age;
    private int dogId;
    private char dogChar;
    private String dogTag;
    private boolean stillInFacility;

    // Constructors
    public Dog(String name, String ownerName, int age, int dogId, boolean stillInFacility) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.dogId = PawesomeUtils.validateDogId(dogId);
        this.dogChar = PawesomeUtils.generateDogChar(this.dogId);
        this.dogTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        this.stillInFacility = stillInFacility;
    }

    public Dog() {
        this.name = "Daniel";
        this.ownerName = "Matthew";
        this.age = 2;
        this.dogId = PawesomeUtils.validateDogId(123);
        this.dogChar = PawesomeUtils.generateDogChar(this.dogId);
        this.dogTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        this.stillInFacility = true;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAge() {
        return age;
    }

    public int getDogId() {
        return dogId;
    }

    public char getDogChar() {
        return dogChar;
    }

    public String getDogTag() {
        return dogTag;
    }

    public boolean isStillInFacility() {
        return stillInFacility;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDogId(int dogId) {
        this.dogId = PawesomeUtils.validateDogId(dogId);
        char newChar = PawesomeUtils.generateDogChar(this.dogId);
        setDogChar(newChar);

        String newTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        setDogTag(newTag);
    }

    public void setDogChar(char dogChar) {
        this.dogChar = dogChar;
        String newTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        setDogTag(newTag);
    }

    public void setDogTag(String dogTag) {
        this.dogTag = dogTag;
    }

    public void setStillInFacility(boolean stillInFacility) {
        this.stillInFacility = stillInFacility;
    }

    // methods
    public String toString() {
        return (name + " is a good dog. They are " + age + " years old and belong to " + ownerName
                + ". They are currently in our facility: " + stillInFacility
                + ". For employee use only: DogTag is " + dogTag + ".");
    }

    public boolean equals(Dog other) {
        boolean partA = this.name == other.name && this.ownerName == other.ownerName
                && this.age == other.age && this.dogId == other.dogId;

        boolean partB = this.dogChar == other.dogChar && this.dogTag == other.dogTag
                && this.stillInFacility == other.stillInFacility;

        return (partA && partB);
    }
}
