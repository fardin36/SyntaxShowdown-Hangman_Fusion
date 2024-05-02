package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;

public class Rules extends JFrame implements ActionListener {

    JButton start, back;
    String name;

    Rules(String name){
        super("Syntax Showdown : Hangman Fusion");

        this.name = name;

        JLabel heading = new JLabel("<html>"+"Hello "+ name +"!" +"<br>"+ "Welcome to Syntax Showdown"+"<html>");
        heading.setBounds(80,100,700,80);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel rules = new JLabel("<html>"+
                    "1. Participation in the quiz is free and open to all." + "<br><br>" +
                    "2. There are a total (not sure yet)numbers of questions. " + "<br><br>" +
                    "3. You only have 15 seconds to answer the question." + "<br><br>" +
                    "4. You lose 1 part of your man every time you skip." + "<br><br>" +
                    "5. You get 10 points on every right ans." + "<br><br>" +
                    "6. You can't submit before commiting all ques." + "<br><br>" +
                "<html>");
        rules.setBounds(70,150,700,350);
        rules.setFont(new Font("Tohama", Font.PLAIN, 16));
        rules.setForeground(Color.WHITE);
        add(rules);

        back = new JButton("Back");
        back.setBounds(300,500,100,30);
        back.setBackground(new Color(22,99,54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(450,500,100,30);
        start.setBackground(new Color(22,99,54));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
//        Image i = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i);
//        JLabel image = new JLabel(i2);
//        image.setBounds(-10,-10,800,650);
//        add(image);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("Chief");
    }
}
