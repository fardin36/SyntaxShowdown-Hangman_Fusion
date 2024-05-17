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
    JButton next, submit, blast, erase, minimize, exit, backward;

    public static int timer = 15, ans_given = 0, count = 0, score = 0, eraseCount = 0, rightCount = 0;
    String name;
    String[][] questions;
    int[] answers;
    HangmanUtils newHangman = new HangmanUtils();

    Quiz(String name) {
        super("Syntax Showdown : Hangman Fusion");
        this.name = name;
        RetrieveData retrieveData = new RetrieveData(15);
        questions = retrieveData.getQuestions();
        answers = retrieveData.getAnswers();

        add(newHangman.addHang());

        qno = new JLabel();
        qno.setBounds(80, 320, 40, 110);
        qno.setFont(new Font("Consolas", Font.PLAIN, 24));
        qno.setForeground(CommonConstants.PINK);
        add(qno);

        question = new JLabel();
        question.setBounds(120, 320, 1140, 110);
        question.setFont(new Font("Tohama", Font.PLAIN, 20));
        question.setForeground(CommonConstants.PINK);
        add(question);

        opt1 = ButtonUtils.newRadioButton(380 + 70, CommonConstants.PINK, CommonConstants.PURPLE, 1);
        opt2 = ButtonUtils.newRadioButton(410 + 70, CommonConstants.PINK, CommonConstants.PURPLE, 2);
        opt3 = ButtonUtils.newRadioButton(440 + 70, CommonConstants.PINK, CommonConstants.PURPLE, 3);
        opt4 = ButtonUtils.newRadioButton(470 + 70, CommonConstants.PINK, CommonConstants.PURPLE, 4);
        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);
        group = ButtonUtils.newButtonGroup(opt1, opt2, opt3, opt4);

        next = ButtonUtils.newJButton("Next", 550, 650, 200, 30, CommonConstants.PINK, CommonConstants.PURPLE);
        next.addActionListener(this);
        add(next);

        submit = ButtonUtils.newJButton("Submit", 800, 650, 200, 30, CommonConstants.PINK, CommonConstants.PURPLE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        erase = ButtonUtils.newJButton("icons/erase.png", 50, 50, 100, 100);
        erase.addActionListener(this);
        erase.setEnabled(false);
        erase.setVisible(false);
        add(erase);


        blast = ButtonUtils.newJButton("icons/blast.png", 50, 160, 100, 100);
        blast.addActionListener(this);
//        blast.setVisible(false);
        add(blast);

        minimize = ToolBarUtils.minBtn();
        minimize.addActionListener(this);
        add(minimize);

        exit = ToolBarUtils.exitBtn();
        exit.addActionListener(this);
        add(exit);

        backward = ToolBarUtils.backBtn();
        backward.addActionListener(this);
        add(backward);

        start(count);

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
        if (e.getSource() == next) {
            repaint();
            update();
        } else if (e.getSource() == blast) {
            if (answers[count] == 1 || answers[count] == 3) {
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            }
            blast.setEnabled(false);
            blast.setVisible(false);
        } else if (e.getSource() == erase) {
            eraseCount--;
            if (eraseCount == 0) {
                erase.setEnabled(false);
                erase.setVisible(false);
            }
            newHangman.undoUpdateImage();
        } else if (e.getSource() == submit) {
            update();
        } else if (e.getSource() == exit) {
            System.exit(50);
        } else if (e.getSource() == minimize) {
            setState(JFrame.ICONIFIED);
        } else if (e.getSource() == backward) {
            new Login();
            setVisible(false);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left = " + timer + "seconds";
        g.setColor(CommonConstants.PINK);
        g.setFont(new Font("Consolas", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 950, 200);
        } else {
            g.drawString("Times up !!", 950, 200);
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
            update();
        }
    }

    public void checkSelection() {
        if (group.getSelection() == null) {
            rightCount = 0;
            newHangman.updateImage();
        } else {
            if (group.getSelection().getActionCommand().equals(String.valueOf(answers[count]))) {
                score++;
                rightCount++;
            } else {
                // Hangman Utils
                rightCount = 0;
                newHangman.updateImage();
            }
        }
    }

    public void update() {
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        ans_given = 1;
        checkSelection();
        if (rightCount != 0 && rightCount % 5 == 0) {
            eraseCount++;
        }
        if (count > 0 && newHangman.getCurrentImageIndex() > 0 && eraseCount > 0) {
            erase.setEnabled(true);
            erase.setVisible(true);
        }
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        if (count == 14) {
            if (newHangman.getIsReset()) {
                newHangman.setIsReset();
                new Score(name, score, false, count);
            } else {
                newHangman.resetImageIndex();
                new Score(name, score, true, count);
            }
            count = 0;
            eraseCount = 0;
            setVisible(false);
        } else {
            if (newHangman.getCurrentImageIndex() == 0 && newHangman.getIsReset()) {
                newHangman.setIsReset();
                new Score(name, score, false, count);
                count = 0;
                eraseCount = 2;
                setVisible(false);
                return;
            }
            count++;
            start(count);
        }
    }

    public void start(int count) {
        qno.setText("<html>" + (count + 1) + ".<html>");
        question.setText("<html>" + questions[count][0] + "<html>");
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);
        group.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("Chief");
    }
}
