package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Score extends JFrame implements ActionListener {
    JButton exit, minimize, exitBtn;
    String scorePage;
    JLabel right, wrong;

    Score(String name, int score, boolean safe, int count) {
        super("Syntax Showdown : Hangman Fusion");
        if (safe) {
            scorePage = "icons/score1.png";
        } else {
            scorePage = "icons/score2.png";
        }

        right = new JLabel(String.valueOf(score));
        right.setBounds(1040, 385, 300, 50);
        right.setFont(new Font("Consolas", Font.BOLD, 50));
        right.setForeground(CommonConstants.PINK);
        add(right);

        wrong = new JLabel(String.valueOf(count - score));
        wrong.setBounds(1075, 450, 300, 50);
        wrong.setFont(new Font("Consolas", Font.BOLD, 50));
        wrong.setForeground(CommonConstants.PINK);
        add(wrong);

        exit = ButtonUtils.newJButton("Next", 580, 620, 120, 30, CommonConstants.PINK, CommonConstants.PURPLE);
        exit.addActionListener(this);
        add(exit);

        minimize = ToolBarUtils.minBtn();
        minimize.addActionListener(this);
        add(minimize);

        exitBtn = ToolBarUtils.exitBtn();
        exitBtn.addActionListener(this);
        add(exitBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(scorePage));
        Image i2 = i1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1280, 720);
        add(image);

        setSize(1280, 720);
        setLocation(40, 10);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("Chief", 0, true, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            new Login();
            setVisible(false);
        } else if (e.getSource() == exitBtn) {
            System.exit(50);
        } else if (e.getSource() == minimize) {
            setState(JFrame.ICONIFIED);
        }
    }
}
