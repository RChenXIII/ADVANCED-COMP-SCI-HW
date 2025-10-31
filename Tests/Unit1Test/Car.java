public class Car {
    public String model;
    public String ownerName;
    public String username;
    public int cleanlinessLevel;
    public boolean needsOilChange;

    public Car(String model, String ownerName, int cleanlinessLevel) {
        this.model = model;
        this.ownerName = ownerName;
        this.username = AutoUtils.generateUsername(ownerName);
        this.cleanlinessLevel = AutoUtils.validateCleanlinessLevel(cleanlinessLevel);
        this.needsOilChange = false;
    }

    public Car() {
        this.model = "Toyota";
        this.ownerName = "Matthew Medovoy";
        this.username = AutoUtils.generateUsername(ownerName);
        this.cleanlinessLevel = 8;
        this.needsOilChange = false;
    }

    public String getModel() {
        return model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getUsername() {
        return username;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public boolean isNeedsOilChange() {
        return needsOilChange;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = AutoUtils.fixName(ownerName);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = AutoUtils.validateCleanlinessLevel(cleanlinessLevel);
    }

    public void setNeedsOilChange(boolean needsOilChange) {
        this.needsOilChange = needsOilChange;
    }

    public String toString() {
        if (needsOilChange) {
            return "\n == ABOUT CAR" + " ==" + "\n Model: " + model + "\n Owner: " + ownerName
                    + "\n Username:  " + AutoUtils.generateUsername(this.username)
                    + "\n Cleanliness Level: "
                    + AutoUtils.validateCleanlinessLevel(this.cleanlinessLevel)
                    + "\n Does car need oil change? Yes";
        } else {
            return "\n == ABOUT CAR" + " ==" + "\n Model: " + model + "\n Owner: " + ownerName
                    + "\n Username:  " + AutoUtils.generateUsername(this.username)
                    + "\n Cleanliness Level: "
                    + AutoUtils.validateCleanlinessLevel(this.cleanlinessLevel)
                    + "\n Does car need oil change? No";
        }
    }

    public boolean equals(Car other) {
        boolean partA = this.model.equals(other.model) && this.ownerName.equals(other.ownerName)
                && this.username == other.username
                && this.cleanlinessLevel == other.cleanlinessLevel;

        boolean partB = this.needsOilChange == other.needsOilChange;

        return (partA && partB);
    }

}
