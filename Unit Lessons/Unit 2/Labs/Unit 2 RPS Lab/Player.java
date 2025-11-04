public class Player {

    private String name;
    private String choice;
    

    public String getName() {
        return name;
    }
    
    public String getChoice() {
        return choice;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    
    public void setChoice(String choice) {
        // Make choice lowercase
        choice = choice.toLowerCase();
        
        // Validate choice using RPSGame's static method
        if (RPSGame.validateChoice(choice)) {
            this.choice = choice;
        } else {

            this.choice = RPSGame.generateRandomChoice();
        }
    }
    

    public String toString() {
        return name + " chose " + choice + ".";
    }
}
