package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.*;
import database.*;

public class Quiz extends JFrame implements ActionListener {

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, blast, erase;

    public static int timer = 15, ans_given = 0, count = 0, score = 0, eraseCount = 2;
    String name;
    String[][] questions;
    int[] answers;

    Color GREEN = new Color(22, 99, 54), YELLOW = new Color(255, 215, 0),
            BLACK = Color.BLACK, WHITE = Color.WHITE;

    Quiz(String name) {
        super("Syntax Showdown : Hangman Fusion");
        this.name = name;
        RetrieveData retrieveData = new RetrieveData(15);
        questions = retrieveData.getQuestions();
        answers = retrieveData.getAnswers();

        add(HangmanUtils.addHang());

        qno = new JLabel();
        qno.setBounds(80, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(120, 400, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = ButtonUtils.newRadioButton(450);
        opt2 = ButtonUtils.newRadioButton(480);
        opt3 = ButtonUtils.newRadioButton(510);
        opt4 = ButtonUtils.newRadioButton(540);
        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);
        group = ButtonUtils.newButtonGroup(opt1, opt2, opt3, opt4);

        next = ButtonUtils.newJButton("Next", 550, 600, 200, 30, GREEN, WHITE);
        next.addActionListener(this);
        add(next);

        submit = ButtonUtils.newJButton("Sumit", 1000, 600, 200, 30, YELLOW, BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        erase = ButtonUtils.newJButton("Erase", 80, 100, 200, 30, YELLOW, BLACK);
        erase.addActionListener(this);
        erase.setEnabled(false);
        add(erase);

        blast = ButtonUtils.newJButton("Blast", 780, 600, 200, 30, GREEN, WHITE);
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
            if (count > 0 && HangmanUtils.getCurrentImageIndex() > 1) {
                erase.setEnabled(true);
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (HangmanUtils.getCurrentImageIndex() == 0 && HangmanUtils.getIsReset()) {
                HangmanUtils.setIsReset();
                count = 0;
                eraseCount = 2;
                setVisible(false);
                new Score(name, score, false);
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
                new Score(name, score, false);
            } else {
                new Score(name, score, true);
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
            if (count > 0 && HangmanUtils.getCurrentImageIndex() > 1) {
                erase.setEnabled(true);
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            } else if (count == 9) {
                checkSelection();
                count = 0;
                eraseCount = 2;
                setVisible(false);
                if (HangmanUtils.getCurrentImageIndex() == 0) {
                    new Score(name, score, false);
                } else {
                    new Score(name, score, true);
                }
            } else {
                checkSelection();
                if (HangmanUtils.getCurrentImageIndex() == 0 && HangmanUtils.getIsReset()) {
                    HangmanUtils.setIsReset();
                    count = 0;
                    eraseCount = 2;
                    setVisible(false);
                    new Score(name, score, false);
                    return;
                }
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
