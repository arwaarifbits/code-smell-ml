package RPSGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//by implementing the actionListener method and adding our buttons to that method we are making sure that when those buttons
//are pressed the GUI will have the responsibility to handle what happens
public class RockPaperScissorGUI extends JFrame implements ActionListener{
    //create buttons for rock paper and scissor
    //we make these global because when we create a listener for each button they can all use one single actionPerformed()
    JButton rockButton , paperButton , scissorButton;
    //label for the computer choice
    JLabel computerChoice;
    //create labels for computer and player scores
    JLabel playerScore , computerScore;
    //obj of our backend file we made
    RockPaperScissor rockPaperScissor;
    public RockPaperScissorGUI(){
        //giving the title for our game
        super("oẳn tù tì");
        //set the size of the gui
        setSize(450,574);
        //we set layout to null so we can add our own absolute values for it ie width height or coordinates
        setLayout(null);
        //load our gui in the center of the screen everytime we run it
        setLocationRelativeTo(null);

        //add the default close on exit so we exit the jvm
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //initialise the rockPaperScissor obj we made above
        rockPaperScissor = new RockPaperScissor();

        getContentPane().setBackground(Color.PINK);

        //function to create our gui components
        addGuiComponents();
    }

    private void addGuiComponents() {
        //initialize the computer score label text using JLabel
        computerScore = new JLabel("Computer: 0");

        //set the x,y coordinates and width/height for our computer score label
        computerScore.setBounds(0,50,450,35);

        //set the font , font weight to bold and font size to 27
        computerScore.setFont(new Font("Monospaced", Font.BOLD,27));

        //align our score label to center
        computerScore.setHorizontalAlignment(SwingConstants.CENTER);

        //add it to our gui
        add(computerScore);

        //now we create the computer choice display
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Monospaced", Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.black,3));
        computerChoice.setOpaque(true);
        computerChoice.setBackground(Color.cyan);
        add(computerChoice);

        //now we create the player score label
        playerScore = new JLabel("Player: 0");
        playerScore.setBounds(0,300,450,30);
        playerScore.setFont(new Font("Monospaced", Font.BOLD,27));
        playerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScore);

        //player buttons
        //rock buttons
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN,18));
        rockButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        rockButton.setBackground(Color.cyan);
        rockButton.addActionListener(this);
        add(rockButton);
        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN,18));
        paperButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        paperButton.setBackground(Color.cyan);
        paperButton.addActionListener(this);
        add(paperButton);
        //scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN,18));
        scissorButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        scissorButton.setBackground(Color.cyan);
        scissorButton.addActionListener(this);
        add(scissorButton);
    }
    //we create a dialog box to show our results and ask if the user wanna try again
    private void showDialog(String message){
        JDialog result = new JDialog(this,"RESULT",true);
        result.setSize(220,120);
        result.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        result.setResizable(false);

        //we create the message label to display the message in our dialog box
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Dialog",Font.PLAIN,18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        result.add(messageLabel,BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset result choice
                computerChoice.setText("?");
                //close the dialog box
                result.dispose();
            }
        });
        result.add(tryAgainButton,BorderLayout.SOUTH);
        result.setLocationRelativeTo(this);
        result.setVisible(true);
    }
    //here we will define the actionListener that we implemented
    @Override
    public void actionPerformed(ActionEvent e) {
        //get our userChoice
        String playerChoice = e.getActionCommand().toString();

        //start the game using our function from the backend file and get our result
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        //load the computer's choice using our getter
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        //update the scores
        computerScore.setText("Computer: "+ rockPaperScissor.getComputerScore());
        playerScore.setText("Player: "+ rockPaperScissor.getPlayerScore());

        //show  result dialog
        showDialog(result);

    }
}
