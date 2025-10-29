public class Cat {
    public String name;
    public String ownerName;
    public int moodLevel;
    public String catId;
    public char catChar;
    public boolean isHungry;

    public Cat(String name, String ownerName, int moodLevel, String catId) {
        this.name = name;
        this.ownerName = ownerName;
        this.moodLevel = PurrfectUtils.validateMoodLevel(moodLevel);
        this.catId = PurrfectUtils.validateCatId(catId);
        this.catChar = PurrfectUtils.generateCatChar(this.catId);
        this.isHungry = true;
    }

    public Cat() {
        this.name = "Matthew";
        this.ownerName = "Justin";
        this.moodLevel = 5;
        this.catId = "1849";
        this.catChar = PurrfectUtils.generateCatChar(this.catId); 
        this.isHungry = true;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public String getCatId() {
        return catId;
    }

    public char getCatChar() {
        return catChar;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = PurrfectUtils.validateMoodLevel(moodLevel);
    }

    public void setCatId(String catId) {
        this.catId = PurrfectUtils.validateCatId(catId);
    }

    public void setCatChar(char catChar) {
        this.catChar = catChar;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public String generateCatTag() {
        return catId + catChar;
    }

    public String toString() {
        return "\n == ABOUT " + name + " ==" + "\n" + name 
            + " is a cat. \n Their tag is " + generateCatTag() + ". \n " 
            + PurrfectUtils.determineCatMood(this); 
    }

    public boolean equals(Cat other) {
        boolean partA = this.name.equals(other.name) && this.ownerName.equals(other.ownerName)
            && this.ownerName == other.ownerName
            && this.generateCatTag().equals(other.generateCatTag());

        boolean partB = this.moodLevel == other.moodLevel && this.isHungry == other.isHungry;

        return (partA && partB);
    }
}