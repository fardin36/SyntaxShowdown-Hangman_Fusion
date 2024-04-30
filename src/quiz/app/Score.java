package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import quiz.app.*;

public class Score extends JFrame {

    Score(String name, int score, boolean safe) {
        super("Syntax Showdown : Hangman Fusion");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 200, 200, 150);
        add(image);
        JLabel heading1, heading2, Score;
        if (safe) {
            heading1 = new JLabel("You saved me chief!");
        } else {
            heading1 = new JLabel("You couldn't save the man!");
        }
        heading1.setBounds(100, 100, 700, 30);
        heading1.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading1.setForeground(CommonConstants.WHITE);
        add(heading1);

        heading2 = new JLabel("Thank You " + name + " for Playing");
        heading2.setBounds(100, 150, 700, 30);
        heading2.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading2.setForeground(CommonConstants.WHITE);
        add(heading2);

        Score = new JLabel("Your score is " + score);
        Score.setBounds(350, 230, 300, 30);
        Score.setFont(new Font("Tahoma", Font.BOLD, 26));
        Score.setForeground(CommonConstants.WHITE);
        add(Score);

        JButton exit = ButtonUtils.newJButton("Next", 380, 300, 120, 30, CommonConstants.GREEN, CommonConstants.WHITE);
        add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

//        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
//        Image ii2 = ii1.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
//        ImageIcon ii3 = new ImageIcon(ii2);
//        JLabel iimage = new JLabel(ii3);
//        iimage.setBounds(-10, -15, 750, 550);
//        add(iimage);

        setSize(1280, 720);
        setLocation(40, 10);
        getContentPane().setBackground(CommonConstants.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("Chief", 0, true);
    }
}
