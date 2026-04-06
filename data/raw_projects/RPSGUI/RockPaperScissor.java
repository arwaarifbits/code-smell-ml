package RPSGUI;

import java.util.Random;

//backend file to handle the game logic
public class RockPaperScissor {
    //this string array stores the computer choice from which it will select
    private static final String[] computerChoices = {"Rock" , "Paper" , "Scissor"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    //variable to store the computer choice and later retrieve it
    private String computerChoice;
    //variable to store the computer and players score
    private int playerScore , computerScore;
    //random class to generate a random number to select a choice for the computer
    private Random random;
    //constructor to initialise the random object
    public RockPaperScissor(){
        random = new Random();
    }
    //we call this method to begin the game
    //this method will return the result that is that computer wins or player wins
    public String playRockPaperScissor(String playerChoice){
        //make a random choice for the computer and store it in our variable
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        //result variable which will be returned as per the winner
        String result = "result";
       //main game logic
        //computer chooses rock
       if(computerChoice.equals("Rock")){
           if(playerChoice.equals("Paper")){
               result = "Player Wins!!";
               playerScore++;
           } else if (playerChoice.equals("Scissor")){
               result = "Computer Wins!!";
               computerScore++;
           }else {
               result = "draw!!";
           }
           //computer chooses paper
       } else if (computerChoice.equals("Paper")){
           if(playerChoice.equals("Scissor")){
               result = "Player Wins!!";
               playerScore++;
           } else if (playerChoice.equals("Rock")){
               result = "Computer Wins!!";
               computerScore++;
           }else {
               result = "draw!!";
           }
           //computer chooses scissor
       } else if (computerChoice.equals("Scissor")){
           if(playerChoice.equals("Rock")){
               result = "Player Wins!!";
               playerScore++;
           } else if (playerChoice.equals("Paper")){
               result = "Computer Wins!!";
               computerScore++;
           }else {
               result = "draw!!";
           }
       }
       return result;
    }
}
