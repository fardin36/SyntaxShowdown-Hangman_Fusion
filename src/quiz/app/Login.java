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

//        JLabel heading = new JLabel("Syntax Showdown");
//        heading.setBounds(80, 60, 400, 45);
//        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
//        heading.setForeground(CommonConstants.WHITE);
//        add(heading);

//        JLabel name = new JLabel("Enter Your Name");
//        name.setBounds(300, 280, 300, 20);
//        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
//        name.setForeground(CommonConstants.SLATE);
//        add(name);

        text = new JTextField();
        text.setBounds(210, 392, 285, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setBorder(null);
        text.setForeground(CommonConstants.AUREOLIN);
        text.setBackground(CommonConstants.RICH_BLACK);
        text.setCaretColor(CommonConstants.AUREOLIN);
        add(text);

        Next = ButtonUtils.newJButton("Next", 360, 450, 120, 25, CommonConstants.AUREOLIN, CommonConstants.RICH_BLACK);
        Next.setBorder(BorderFactory.createLineBorder(CommonConstants.RICH_BLACK, 2));
        Next.addActionListener(this);
        add(Next);

        back = ButtonUtils.newJButton("Back", 220, 450, 120, 25, CommonConstants.RICH_BLACK, CommonConstants.AUREOLIN);
        back.setBorder(BorderFactory.createLineBorder(CommonConstants.RICH_BLACK, 2));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1280, 720);
        add(image);

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
//            setState(JFrame.ICONIFIED);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
