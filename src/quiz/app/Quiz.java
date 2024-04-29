package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.HangmanUtils;
import database.RetrieveData;

public class Quiz extends JFrame implements ActionListener {

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, blast, erase;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    public static int eraseCount = 2;
    String name;
    String[][] questions;
    int[] answers;

    Quiz(String name) {
        super("Syntax Showdown : Hangman Fusion");
        this.name = name;
        RetrieveData retrieveData = new RetrieveData(15);
        questions = retrieveData.getQuestions();
        answers = retrieveData.getAnswers();
        /*
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        Image i = i1.getImage().getScaledInstance(1280,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel img = new JLabel(i2);
        img.setBounds(0,0,1280, 300);
        add(img);
         */

        // adding Hangman image initially
        add(HangmanUtils.addHang());

        qno = new JLabel();
        qno.setBounds(80, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(120, 400, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(110, 450, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(110, 480, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(110, 510, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(110, 540, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        next = new JButton("Next");
        next.setBounds(550, 600, 200, 30);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1000, 600, 200, 30);
        submit.setBackground(new Color(255, 215, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        erase = new JButton("Erase");
        erase.setBounds(80, 100, 200, 30);
        erase.setBackground(new Color(255, 215, 0));
        erase.setForeground(Color.BLACK);
        erase.addActionListener(this);
        erase.setEnabled(false);
        add(erase);

        blast = new JButton("Blast");
        blast.setBounds(780, 600, 200, 30);
        blast.setBackground(new Color(22, 99, 54));
        blast.setForeground(Color.WHITE);
        blast.addActionListener(this);
        add(blast);

        start(count);

        setSize(1280, 720);
        setLocation(40, 10);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            checkSelection();
            if (count == 1) {
                erase.setEnabled(true);
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (HangmanUtils.getCurrentImageIndex() == 0) {
                count = 0;
                eraseCount = 2;
                setVisible(false);
                new Score(name, score, true);
                return;
            }
            count++;
            start(count);
        } else if (e.getSource() == blast) {
            if (answers[count] == 1 || answers[count] == 3) {
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            }
            blast.setEnabled(false);
        } else if (e.getSource() == erase) {
            eraseCount--;
            if (eraseCount == 0) {
                erase.setEnabled(false);
            }
            HangmanUtils.undoUpdateImage();
        } else if (e.getSource() == submit) {
            ans_given = 1;
            checkSelection();
            count = 0;
            eraseCount = 2;
            setVisible(false);
            if (HangmanUtils.getCurrentImageIndex() == 0) {
                new Score(name, score, true);
            } else {
                new Score(name, score, false);
            }
        }
    }

    public void checkSelection() {
        if (group.getSelection() == null) {
            HangmanUtils.updateImage();
        } else {
            if (group.getSelection().getActionCommand().equals(questions[count][answers[count]])) {
                score += 10;
            } else {
                // Hangman Utils
                HangmanUtils.updateImage();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left = " + timer + "seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 950, 500);
        } else {
            g.drawString("Times up !!", 950, 500);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception E) {
            E.fillInStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if (count == 1) {
                erase.setEnabled(true);
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                checkSelection();
                count = 0;
                eraseCount = 2;
                setVisible(false);
                if (HangmanUtils.getCurrentImageIndex() == 0) {
                    new Score(name, score, true);
                } else {
                    new Score(name, score, false);
                }
            } else {
                checkSelection();
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText(" " + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("Chief");
    }
}
