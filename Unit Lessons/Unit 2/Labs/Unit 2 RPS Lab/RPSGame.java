import java.util.Scanner;
import java.util.Random;

public class RPSGame {

    private Player player;
    private NPC opponent;
    

    public RPSGame(Player player, NPC opponent) {
        this.player = player;
        this.opponent = opponent;
    }
    
    // Instance Methods
    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt for name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        // Prompt for choice with validation
        String choice = "";
        int attempts = 0;
        
        while (attempts < 3 && !validateChoice(choice)) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            choice = scanner.nextLine().toLowerCase();
            attempts++;
            
            if (!validateChoice(choice) && attempts < 3) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        // If three failed attempts, assign random choice
        if (!validateChoice(choice)) {
            choice = generateRandomChoice();
            System.out.println("Too many invalid attempts. Randomly assigned: " + choice);
        }
        
        setPlayerValues(name, choice);
    }
    
    public void setPlayerValues(String name, String choice) {
        player.setName(name);
        player.setChoice(choice);
    }
    
    public boolean didPlayerWin() {
        String playerChoice = player.getChoice();
        String opponentChoice = opponent.getChoice();
        
        // Guard statements for player winning conditions
        if (playerChoice.equals("rock") && opponentChoice.equals("scissors")) {
            return true;
        }
        if (playerChoice.equals("paper") && opponentChoice.equals("rock")) {
            return true;
        }
        if (playerChoice.equals("scissors") && opponentChoice.equals("paper")) {
            return true;
        }
        
        return false;
    }
    
    public String toString() {
        String winner;
        String message;
        
        if (didPlayerWin()) {
            winner = player.getName() + " won!";
            message = "Congratulations!";
        } else {
            winner = "Opponent won!";
            message = "Better luck next time!";
        }
        
        return winner + "\n" + message;
    }
    
    public String displayResults() {
        return "== GAME RESULTS ==\n" +
               player.getName() + " chose " + player.getChoice() + ".\n" +
               "Opponent chose " + opponent.getChoice() + ".\n" +
               toString();
    }
    
    // Static Methods
    public static boolean validateChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
    
    public static String generateRandomChoice() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        
        if (randomNum == 0) {
            return "rock";
        } else if (randomNum == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }
    
}
