// A Swimmable animal CAN SWIM.
// This is a "can do" capability that many different animals can add.
public interface Swimmable {

    // Basic Characteristics of swimming animals

    // returns the typical swimming speed of the animal in km/h
    public double getSwimSpeed();

    // returns the typical depth the animal swims at in meters
    public double getPreferredDepth();

    // Basic Behaviors - BE CREATIVE

    // prints out how the animal enters the water
    public void enterWater();

    // prints out how the animal swims
    public void swim();

    // prints out how the animal leaves the water
    public void exitWater();

}

