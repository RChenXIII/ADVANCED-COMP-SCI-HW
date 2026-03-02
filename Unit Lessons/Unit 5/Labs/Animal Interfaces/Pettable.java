// A Pettable animal CAN BE A PET.
// This is a "can do" capability that many different animals can add.
public interface Pettable {

    // Basic Characteristics of animals that can be pets

    // returns how friendly the animal is on a scale from 1 to 10
    public int getFriendlinessLevel();

    // returns how energetic the animal is on a scale from 1 to 10
    public int getEnergyLevel();

    // Basic Behaviors - BE CREATIVE

    // prints out how the animal reacts when it sees a person
    public void greetHuman();

    // prints out how the animal reacts when it is being petted
    public void bePetted();

    // prints out how the animal plays with a human
    public void playWithHuman();

}

