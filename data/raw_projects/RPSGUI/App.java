package RPSGUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        //invoking the utilities so that our gui runs on edt which is a thread that handles ui stuff
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RockPaperScissorGUI rockPaperScissorGUI = new RockPaperScissorGUI();

                //we display our gui now
                rockPaperScissorGUI.setVisible(true);
            }
        });
    }
}
