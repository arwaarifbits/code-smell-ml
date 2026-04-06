// File Name: OnlineExamSystemFile.java

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class OnlineExamSystemFile extends JFrame implements ActionListener {

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String[]> options = new ArrayList<>();
    ArrayList<Character> answers = new ArrayList<>();

    JLabel questionLabel;
    JRadioButton[] optionButtons;
    ButtonGroup optionsGroup;
    JButton nextButton, prevButton, submitButton;

    int currentQuestion = 0;
    char[] userAnswers;

    public OnlineExamSystemFile() {
        // Modern Look & Feel
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception ignored){}

        loadQuestions("questions.txt");
        userAnswers = new char[questions.size()];

        // Frame settings
        setTitle("Online Examination System");
        setSize(700, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Question panel
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBackground(new Color(245, 245, 245));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        questionLabel.setVerticalAlignment(SwingConstants.TOP);
        questionPanel.add(questionLabel, BorderLayout.CENTER);
        add(questionPanel, BorderLayout.NORTH);

        // Options panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        optionsPanel.setBackground(Color.white);

        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 16)); // font size stays same
            optionButtons[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            optionButtons[i].setBackground(Color.white);
            optionButtons[i].setFocusable(false);
            optionButtons[i].setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10)); // reduced padding
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
            optionsPanel.add(Box.createRigidArea(new Dimension(0, 5))); // reduced spacing between options
        }

        add(optionsPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonsPanel.setBackground(new Color(245, 245, 245));

        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");

        // Uniform button size
        Dimension btnSize = new Dimension(120, 40);
        prevButton.setPreferredSize(btnSize);
        nextButton.setPreferredSize(btnSize);
        submitButton.setPreferredSize(btnSize);

        // Colors
        prevButton.setBackground(new Color(200, 220, 255));
        nextButton.setBackground(new Color(200, 220, 255));
        submitButton.setBackground(new Color(200, 220, 255));

        prevButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        prevButton.addActionListener(this);
        nextButton.addActionListener(this);
        submitButton.addActionListener(this);

        buttonsPanel.add(prevButton);
        buttonsPanel.add(nextButton);
        buttonsPanel.add(submitButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        loadQuestion(currentQuestion);
        setVisible(true);
    }

    void loadQuestions(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line); // Question
                String[] opts = new String[4];
                for (int i = 0; i < 4; i++) opts[i] = br.readLine(); // Options
                options.add(opts);
                answers.add(br.readLine().charAt(0)); // Correct answer
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading questions file: " + e.getMessage());
            System.exit(1);
        }
    }

    void loadQuestion(int index) {
        questionLabel.setText("<html><body style='width:600px'>" + (index + 1) + ". " + questions.get(index) + "</body></html>");
        String[] opts = options.get(index);
        for (int i = 0; i < 4; i++) optionButtons[i].setText(opts[i]);

        optionsGroup.clearSelection();
        if (userAnswers[index] != '\u0000') {
            switch (userAnswers[index]) {
                case 'A' -> optionButtons[0].setSelected(true);
                case 'B' -> optionButtons[1].setSelected(true);
                case 'C' -> optionButtons[2].setSelected(true);
                case 'D' -> optionButtons[3].setSelected(true);
            }
        }

        prevButton.setEnabled(index != 0);
        nextButton.setEnabled(index != questions.size() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) userAnswers[currentQuestion] = (char) ('A' + i);
        }

        if (e.getSource() == nextButton && currentQuestion < questions.size() - 1) {
            currentQuestion++;
            loadQuestion(currentQuestion);
        } else if (e.getSource() == prevButton && currentQuestion > 0) {
            currentQuestion--;
            loadQuestion(currentQuestion);
        } else if (e.getSource() == submitButton) {
            int score = 0;
            for (int i = 0; i < questions.size(); i++) {
                if (userAnswers[i] == answers.get(i)) score++;
            }
            JOptionPane.showMessageDialog(this, "Your Score: " + score + "/" + questions.size());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OnlineExamSystemFile::new);
    }
}
