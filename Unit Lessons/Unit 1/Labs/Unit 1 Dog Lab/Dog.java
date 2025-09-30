public class Dog {
    private String name;
    private String ownerName;
    private int age;
    private int dogId;
    private char dogChar;
    private String dogTag;
    private boolean stillInFacility;

    public Dog(String name, String ownerName, int age, int dogId) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.dogId = dogId;
        this.dogChar = generateDogChar();
        this.dogTag = generateDogTag();
        this.stillInFacility = true;
    }

    public Dog() {
        this.name = "Daniel";
        this.ownerName = "Matthew";
        this.age = 2;
        this.dogId = 123;
        this.dogChar = generateDogChar();
        this.dogTag = generateDogTag();
        this.stillInFacility = true;
    }

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

    public boolean getIsStillInFacility() {
        return stillInFacility;
    }

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
        this.dogId = dogId;
    }

    public void setDogChar(char dogChar) {
        this.dogChar = dogChar;
    }

    public void setDogTag(String dogTag) {
        this.dogTag = dogTag;
    }

    public void setStillInFacility(boolean stillInFacility) {
        this.stillInFacility = stillInFacility;
    }

    public String toString() {
        String firstPart = (name + " is a good dog. They are " + age + " years old and belong to "
                + ownerName + ".");
        String secondPart = ("For employee use only: DogTag is " + dogTag + dogChar);
        if (stillInFacility) {
            return (firstPart + " They are currently in our facility. " + secondPart);
        }
        if (!stillInFacility) {
            return (firstPart + " They are not currently in our facility. " + secondPart);
        }


    }

    public boolean equals(Dog other) {

        boolean partA = this.name == other.name && this.ownerName == other.ownerName
                && this.age == other.age && this.dogId == other.dogId;

        boolean partB = this.dogChar == other.dogChar && this.dogTag == other.dogTag
                && this.stillInFacility == other.stillInFacility;

        return (partA && partB);
    }

    public String generateDogTag() {
        return "" + this.dogId % 10 + (this.dogId / 10) % 10 + this.dogId / 100;
    }
}

