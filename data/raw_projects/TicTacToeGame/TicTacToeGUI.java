package TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private JLabel turnLabel , scoreLabel , resultLabel;
    private JDialog resultDialog;
    private JButton[][] board;
    //isPlayerOne - flag that indicates whether the player is x or not
    private boolean isPlayerOne;
    //xScore keeps the track of x score
    //oScore keeps the track of o score
    //moveCounter is used to count the no of moves useful in determining if there is a draw
    private int xScore , oScore , moveCounter;
    public TicTacToeGUI(){
        super("Tic Tac Toe");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);
        //initialise the board
        board = new JButton[3][3];
        //player x moves first
        isPlayerOne = true;

        createResultDialog();

        addGUIComponent();
    }

    private void addGUIComponent(){
        //bar label
        JLabel barLabel = new JLabel();
        barLabel.setOpaque(true);
        barLabel.setBackground(CommonConstants.BAR_COLOR);
        barLabel.setBounds(0,0,CommonConstants.FRAME_SIZE.width, 40);

        //turn label which shows whose turn
        turnLabel = new JLabel(CommonConstants.X_LABEL);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setPreferredSize(new Dimension(100,turnLabel.getPreferredSize().height));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(CommonConstants.X_COLOR);
        turnLabel.setForeground(CommonConstants.BOARD_COLOR);
        turnLabel.setFont(new Font("Dialog",Font.PLAIN,40));
        turnLabel.setBounds(
                (CommonConstants.FRAME_SIZE.width - turnLabel.getPreferredSize().width)/2,
                0,
                turnLabel.getPreferredSize().width-10,
                turnLabel.getPreferredSize().height+24
        );

        //score label
        scoreLabel = new JLabel(CommonConstants.SCORE_LABEL);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(CommonConstants.BOARD_COLOR);
        scoreLabel.setFont(new Font("Dialog",Font.PLAIN,40));
        scoreLabel.setBounds(0,
                turnLabel.getY() + turnLabel.getPreferredSize().height + 25,
                CommonConstants.FRAME_SIZE.width,
                scoreLabel.getPreferredSize().height
        );

        //game board
        GridLayout gridLayout = new GridLayout(3,3);
        JPanel gamePanel = new JPanel(gridLayout);
        gamePanel.setBounds(0,
                scoreLabel.getY() + scoreLabel.getPreferredSize().height + 35,
                CommonConstants.BOARD_SIZE.width,
                CommonConstants.BOARD_SIZE.height
                );
        //creating board
        for(int i=0 ; i< board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                JButton button = new JButton();
                button.setFont(new Font("Dialog",Font.PLAIN,180));
                button.setPreferredSize(CommonConstants.BUTTON_SIZE);
                button.setBackground(CommonConstants.BACKGROUND_COLOR);
                button.addActionListener(this);
                button.setBorder(BorderFactory.createLineBorder(CommonConstants.BOARD_COLOR));
                board[i][j]=button;
                gamePanel.add(button);
            }
        }
        //reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Dialog",Font.PLAIN,24));
        resetButton.setBackground(CommonConstants.BOARD_COLOR);
        resetButton.addActionListener(this);
        resetButton.setBounds(
                (CommonConstants.FRAME_SIZE.width - resetButton.getPreferredSize().width)/2,
                CommonConstants.FRAME_SIZE.height-100,
                resetButton.getPreferredSize().width,
                resetButton.getPreferredSize().height
        );
        getContentPane().add(turnLabel);
        getContentPane().add(barLabel);
        getContentPane().add(scoreLabel);
        getContentPane().add(gamePanel);
        getContentPane().add(resetButton);
    }

    private void createResultDialog(){
        resultDialog = new JDialog(this,"Result",true);
        resultDialog.getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);
        resultDialog.setResizable(false);
        resultDialog.setSize(CommonConstants.RESULT_DIALOG_SIZE);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setLayout(new GridLayout(2,1));
        resultDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                resetGame();
            }
        });
        //result label
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setForeground(CommonConstants.BOARD_COLOR);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //restart button
        JButton restartButton = new JButton("Play Again");
        restartButton.setBackground(CommonConstants.BOARD_COLOR);
        restartButton.addActionListener(this);

        resultDialog.add(resultLabel);
        resultDialog.add(restartButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Reset") || command.equals("Play Again")){
            //we reset the game
            resetGame();
            //we only reset the scores when we reset the game
            if(command.equals("Reset") ){
                xScore = oScore = 0;
            }
            //if we press play again we only come back to our board
            if(command.equals("Play Again")){
                resultDialog.setVisible(false);
            }
        }else{
            //player move next
            JButton button = (JButton) e.getSource();
            if(button.getText().isEmpty()){
                moveCounter++;

                //mark the button with x/o only if it hasnt been updated yet
                if(isPlayerOne){
                    button.setText(CommonConstants.X_LABEL);
                    button.setForeground(CommonConstants.X_COLOR);

                    turnLabel.setText(CommonConstants.O_LABEL);
                    turnLabel.setBackground(CommonConstants.O_COLOR);

                    isPlayerOne = false;
                }else{
                    button.setText(CommonConstants.O_LABEL);
                    button.setForeground(CommonConstants.O_COLOR);

                    turnLabel.setText(CommonConstants.X_LABEL);
                    turnLabel.setBackground(CommonConstants.X_COLOR);

                    isPlayerOne = true;
                }
                //checking if someone has won after each move
                if(isPlayerOne){
                    //check if the last O move led to a win
                    checkOWin();
                }{
                    //check if the last x move led to a win
                    checkXWin();
                }

                //check for draw
                checkDraw();

                //update the score label
                scoreLabel.setText("X: "+xScore+" | O: "+oScore);
            }
            repaint();
            revalidate();
        }
    }

    private void checkXWin() {
        String result = "X Wins";

        //check rows
        for(int row = 0; row< board.length ; row++){
            if(board[row][0].getText().equals("X") && board[row][1].getText().equals("X") && board[row][2].getText().equals("X")){
                resultLabel.setText(result);
                resultDialog.setVisible(true);
                xScore++;
            }
        }
        //check columns
        for(int col = 0; col< board.length ; col++){
            if(board[0][col].getText().equals("X") && board[1][col].getText().equals("X") && board[2][col].getText().equals("X")){
                resultLabel.setText(result);
                resultDialog.setVisible(true);
                xScore++;
            }
        }
        //diagonals
        if(board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")){
            resultLabel.setText(result);
            resultDialog.setVisible(true);
            xScore++;
        }
        if(board[0][2].getText().equals("X") && board[1][1].getText().equals("X") && board[2][0].getText().equals("X")){
            resultLabel.setText(result);
            resultDialog.setVisible(true);
            xScore++;
        }
    }

    private void checkOWin() {
        String result = "O Wins";

        //check rows
        for(int row = 0; row< board.length ; row++){
            if(board[row][0].getText().equals("O") && board[row][1].getText().equals("O") && board[row][2].getText().equals("O")){
                resultLabel.setText(result);
                resultDialog.setVisible(true);
                oScore++;
            }
        }
        //check columns
        for(int col = 0; col< board.length ; col++){
            if(board[0][col].getText().equals("O") && board[1][col].getText().equals("O") && board[2][col].getText().equals("O")){
                resultLabel.setText(result);
                resultDialog.setVisible(true);
                oScore++;
            }
        }
        //diagonals
        if(board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")){
            resultLabel.setText(result);
            resultDialog.setVisible(true);
            oScore++;
        }
        if(board[0][2].getText().equals("O") && board[1][1].getText().equals("O") && board[2][0].getText().equals("O")){
            resultLabel.setText(result);
            resultDialog.setVisible(true);
            oScore++;
        }
    }
    private void checkDraw(){
        if(moveCounter>=9){
            resultLabel.setText("Draw");
            resultDialog.setVisible(true);
        }
    }

    private void resetGame() {
        //reset player back to x
        isPlayerOne = true;
        turnLabel.setText(CommonConstants.X_LABEL);
        turnLabel.setBackground(CommonConstants.X_COLOR);

        //reset the score
        scoreLabel.setText(CommonConstants.SCORE_LABEL);

        //reset the board
        for(int i=0 ; i< board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setText("");
            }
        }
        //reset move counter
        moveCounter = 0;
    }
}
