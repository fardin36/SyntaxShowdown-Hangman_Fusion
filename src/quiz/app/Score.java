package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Score extends JFrame implements ActionListener {
    JButton exit;
    String scorePage = null;
    JLabel right, wrong;

    Score(String name, int score, boolean safe, int count) {
        super("Syntax Showdown : Hangman Fusion");
        if (safe){
            scorePage = "icons/score1.png";
        }else{
            scorePage = "icons/score2.png";
        }

//        JLabel heading1, heading2, Score;
//        if (safe) {
//            heading1 = new JLabel("You saved me chief!");
//        } else {
//            heading1 = new JLabel("You couldn't save the man!");
//        }
//        heading1.setBounds(100, 100, 700, 30);
//        heading1.setFont(new Font("Tahoma", Font.BOLD, 26));
//        heading1.setForeground(Color.WHITE);
//        add(heading1);

//        heading2 = new JLabel("Thank You " + name + " for Playing");
//        heading2.setBounds(100, 150, 700, 30);
//        heading2.setFont(new Font("Tahoma", Font.BOLD, 26));
//        heading2.setForeground(Color.WHITE);
//        add(heading2);

        right = new JLabel(String.valueOf(score));
        right.setBounds(1090, 365, 300, 50);
        right.setFont(new Font("Consolas", Font.BOLD, 50));
        right.setForeground(CommonConstants.RICH_BLACK);
        add(right);

        wrong = new JLabel(String.valueOf(count-score));
        wrong.setBounds(1050, 410, 300, 50);
        wrong.setFont(new Font("Consolas", Font.BOLD, 50));
        wrong.setForeground(CommonConstants.RICH_BLACK);
        add(wrong);

        exit = ButtonUtils.newJButton("Next", 580, 620, 120, 30, CommonConstants.RICH_BLACK, CommonConstants.AUREOLIN);
        exit.addActionListener(this);
        add(exit);

//        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
//        Image ii2 = ii1.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
//        ImageIcon ii3 = new ImageIcon(ii2);
//        JLabel iimage = new JLabel(ii3);
//        iimage.setBounds(-10, -15, 750, 550);
//        add(iimage);

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
//        setUndecorated(true);
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
        }
    }
}
