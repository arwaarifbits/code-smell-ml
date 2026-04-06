package GuiLoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPage extends JFrame implements ActionListener {
    public loginPage(){
        super("My Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(480,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#FFD1DC"));

        addGuiComponents();
    }
    JTextField username;
    JPasswordField passField;
    private void addGuiComponents(){
        JLabel userLabel = new JLabel("User");
        userLabel.setFont(new Font("Dialog",Font.BOLD,20));
        userLabel.setBounds(90,150,100,userLabel.getPreferredSize().height);
        add(userLabel);
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Dialog",Font.BOLD,20));
        passLabel.setBounds(90,180,150,passLabel.getPreferredSize().height);
        add(passLabel);
        username = new JTextField();
        username.setBounds(150,150,userLabel.getWidth()+50,userLabel.getHeight());
        add(username);
        passField = new JPasswordField();
        passField.setBounds(190,180,passLabel.getWidth(),passLabel.getHeight());
        add(passField);
        JButton loginButton = new JButton("Login");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setBounds(200,250,70,20);
        loginButton.setOpaque(true);
        loginButton.setBackground(Color.cyan);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        loginButton.addActionListener(this);
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = username.getText().trim();
        String pass = new String(passField.getPassword());

        if(user.equals("admin") && pass.equals("1234")){
            JOptionPane.showMessageDialog(null,"Login Successful");
        }else if(user.isEmpty()){
            JOptionPane.showMessageDialog(null,"Details empty");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Login Details");
        }

    }
}
