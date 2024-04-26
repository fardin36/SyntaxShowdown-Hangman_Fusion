package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Score extends JFrame {

    Score(String name, int score){
        super("Syntax Showdown : Hangman Fusion");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,200,200,150);
        add(image);

        JLabel heading = new JLabel("Thank You"+ name +"for Playing QUIZ TEST");
        heading.setBounds(100,80,700,30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 26));
        add(heading);

        JLabel Score = new JLabel("Your score is "+ score);
        Score.setBounds(350,200,300,30);
        Score.setFont(new Font("Tahoma",Font.BOLD, 26));
        add(Score);

        JButton exit = new JButton("EXIT");
        exit.setBounds(380,270,120,30);
        exit.setBackground(new Color(22,99,54));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image ii2 = ii1.getImage().getScaledInstance(750,550, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(60,200,750,550);
        add(image);

        setSize(750, 550);
        setLocation(400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("Chief",0);
    }
}
