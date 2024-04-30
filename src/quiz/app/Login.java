package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Login extends JFrame implements ActionListener {

    JTextField text;
    JButton Next, back;

    Login() {
        super("Syntax Showdown : Hangman Fusion");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(450, -10, 500, 500);
        add(image);

//        JLabel heading = new JLabel("Syntax Showdown");
//        heading.setBounds(80, 60, 400, 45);
//        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
//        heading.setForeground(CommonConstants.WHITE);
//        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(160, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(CommonConstants.WHITE);
        add(name);

        text = new JTextField();
        text.setBounds(80, 200, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setForeground(CommonConstants.WHITE);
        text.setBackground(CommonConstants.BLACK);
        text.setCaretColor(CommonConstants.WHITE);
        add(text);

        Next = ButtonUtils.newJButton("Next", 100, 270, 120, 25, CommonConstants.GREEN, CommonConstants.WHITE);
        Next.addActionListener(this);
        add(Next);

        back = ButtonUtils.newJButton("Back", 250, 270, 120, 25, CommonConstants.GREEN, CommonConstants.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1000, 500);
        setLocation(200, 150);
        getContentPane().setBackground(CommonConstants.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Next) {
            String name = text.getText();
            setVisible(false);
            new Rules(name);
        } else if (e.getSource() == back) {
            System.exit(50);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
