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
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(640, 720, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(500, 0, 640, 720);
        add(image);

//        JLabel heading = new JLabel("Syntax Showdown");
//        heading.setBounds(80, 60, 400, 45);
//        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
//        heading.setForeground(CommonConstants.WHITE);
//        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(300, 280, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(CommonConstants.SLATE);
        add(name);

        text = new JTextField();
        text.setBounds(220, 330, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setForeground(CommonConstants.SLATE);
        text.setBackground(CommonConstants.EBONY);
        text.setCaretColor(CommonConstants.SLATE);
        add(text);

        Next = ButtonUtils.newJButton("Next", 390, 380, 120, 25, CommonConstants.CYAN, CommonConstants.EBONY);
        Next.addActionListener(this);
        add(Next);

        back = ButtonUtils.newJButton("Back",  240, 380,120, 25, CommonConstants.PINK, CommonConstants.EBONY);
        back.addActionListener(this);
        add(back);

        setSize(1280, 720);
        setLocation(40, 10);
        getContentPane().setBackground(CommonConstants.EBONY);
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
