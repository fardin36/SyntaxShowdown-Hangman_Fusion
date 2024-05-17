package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Rules extends JFrame implements ActionListener {

    JButton start, back, minimize, exit, backward;
    String name;
    JLabel heading, rules;

    Rules(String name) {
        super("Syntax Showdown : Hangman Fusion");

        this.name = name;

        rules = new JLabel("<html>"
                + "1. Participation in the quiz is free and open to all." + "<br><br>"
                + "2. There is a total of 15 questions. " + "<br><br>"
                + "3. You only have 15 seconds to answer the question." + "<br><br>"
                + "4. You lose 1 part of your man every time you answer wrong/skip." + "<br><br>"
                + "5. You get 1 points on every right answer."
                + "<br><br>" + "6. You get 1 bonus point for 5 consecutive right answers." + "<br><br>"
                + "7. You can't submit before commiting all questions." + "<br><br>"
                + "<html>"
        );
        rules.setBounds(70, 210, 1200, 450);
        rules.setFont(new Font("Consolas", Font.PLAIN, 20));
        rules.setForeground(CommonConstants.PINK);
        add(rules);

        back = ButtonUtils.newJButton("Back", 450, 610, 120, 25, CommonConstants.PINK, CommonConstants.PURPLE);
        back.setBorder(BorderFactory.createLineBorder(CommonConstants.PINK, 2));
        back.addActionListener(this);
        add(back);

        start = ButtonUtils.newJButton("Start", 590, 610, 120, 25, CommonConstants.PURPLE, CommonConstants.PINK);
        start.setBorder(BorderFactory.createLineBorder(CommonConstants.PINK, 2));
        start.addActionListener(this);
        add(start);

        minimize = ToolBarUtils.minBtn();
        minimize.addActionListener(this);
        add(minimize);

        exit = ToolBarUtils.exitBtn();
        exit.addActionListener(this);
        add(exit);

        backward = ToolBarUtils.backBtn();
        backward.addActionListener(this);
        add(backward);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rules.png"));
        JLabel image = new JLabel(i1);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            new Quiz(name);
            setVisible(false);
        } else if (e.getSource() == back || e.getSource() == backward) {
            new Login();
            setVisible(false);
        } else if (e.getSource() == minimize) {
            setState(JFrame.ICONIFIED);
        } else if (e.getSource() == exit) {
            System.exit(50);
        }
    }

    public static void main(String[] args) {
        new Rules("Chief");
    }
}
