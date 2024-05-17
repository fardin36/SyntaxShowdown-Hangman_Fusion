package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Login extends JFrame implements ActionListener {

    JTextField text;
    JButton Next, back, minimize, exit, backward;

    Login() {
        super("Syntax Showdown : Hangman Fusion");
        setLayout(null);

        text = new JTextField();
        text.setBounds(220, 392, 265, 25);
        text.setFont(new Font("Arial Black", Font.BOLD, 18));
        text.setBorder(null);
        text.setForeground(CommonConstants.PURPLE);
        text.setBackground(CommonConstants.PINK);
        text.setCaretColor(CommonConstants.PURPLE);
        add(text);

        Next = ButtonUtils.newJButton("Next", 360, 450, 120, 25, CommonConstants.PURPLE, CommonConstants.PINK);
//        Next.setBorder(BorderFactory.createLineBorder(CommonConstants.PINK, 2));
        Next.addActionListener(this);
        add(Next);

        back = ButtonUtils.newJButton("Back", 220, 450, 120, 25, CommonConstants.PINK, CommonConstants.PURPLE);
//        back.setBorder(BorderFactory.createLineBorder(CommonConstants.PINK, 2));
        back.addActionListener(this);
        add(back);

        minimize = ToolBarUtils.minBtn();
        minimize.addActionListener(this);
        add(minimize);

        exit = ToolBarUtils.exitBtn();
        exit.addActionListener(this);
        add(exit);

        backward = ToolBarUtils.backBtn();
        backward.addActionListener(this);
        add(backward);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1280, 720);
        add(image);

        setSize(1280, 720);
        setLocation(40, 10);
        getContentPane().setBackground(CommonConstants.PURPLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Next) {
            String name = text.getText();
            new Rules(name);
            setVisible(false);
        } else if (e.getSource() == back || e.getSource() == exit || e.getSource() == backward) {
            System.exit(50);
        } else if (e.getSource() == minimize) {
            setState(JFrame.ICONIFIED);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
