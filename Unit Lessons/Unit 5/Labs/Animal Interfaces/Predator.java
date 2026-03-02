// A Predator animal CAN HUNT.
// This is a "can do" capability that many different animals can add.
public interface Predator {

    // Basic Characteristics of predators

    // returns the primary type of prey this predator hunts
    public String getPrimaryPrey();

    // returns the typical size of prey in kilograms
    public double getAveragePreyMass();

    // Basic Behaviors - BE CREATIVE

    // prints out how the animal stalks its prey
    public void stalkPrey();

    // prints out how the animal attacks its prey
    public void attackPrey();

    // prints out how the animal eats its prey
    public void eatPrey();

}

