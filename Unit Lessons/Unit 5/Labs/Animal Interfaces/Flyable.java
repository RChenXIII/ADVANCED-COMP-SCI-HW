// A Flyable animal CAN FLY.
// This is a "can do" capability that many different animals can add.
public interface Flyable {

    // Basic Characteristics of flying animals

    // returns the typical flight speed of the animal in km/h
    public double getFlightSpeed();

    // returns the maximum altitude the animal can reach in meters
    public double getMaxAltitude();

    // Basic Behaviors - BE CREATIVE

    // prints out how the animal takes off
    public void takeOff();

    // prints out how the animal flies
    public void fly();

    // prints out how the animal lands
    public void land();

}

