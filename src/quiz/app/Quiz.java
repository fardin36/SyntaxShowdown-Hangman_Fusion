package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.app.HangmanUtils;
import quiz.app.Questions;

public class Quiz extends JFrame implements ActionListener {

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, help, changeButton;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;
    String hangImage = "hangs/1.png";

    Quiz(String name) {
        super("Syntax Showdown : Hangman Fusion");
        this.name = name;

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
        // ==========

        qno = new JLabel();
        qno.setBounds(80, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(120, 400, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(140, 450, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(140, 480, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(140, 510, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(140, 540, 700, 30);
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

        help = new JButton("Help");
        help.setBounds(780, 600, 200, 30);
        help.setBackground(new Color(22, 99, 54));
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);

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
            if (group.getSelection() == null) {
                Questions.useranswers[count][0] = "";
                // Hangman funcions
                HangmanUtils.updateImage();
                // =======
            } else {
                Questions.useranswers[count][0] = group.getSelection().getActionCommand();
            }

            for (int i = 0; i < Questions.useranswers.length; i++) {
                if (Questions.useranswers[count][0].equals(Questions.answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (e.getSource() == help) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            help.setEnabled(false);
        } else if (e.getSource() == submit) {
            ans_given = 1;
            if (group.getSelection() == null) {
                Questions.useranswers[count][0] = "";
                // Hangman funcion
                HangmanUtils.updateImage();
                // =======
            } else {
                Questions.useranswers[count][0] = group.getSelection().getActionCommand();
            }
            for (int i = 0; i < Questions.useranswers.length; i++) {
                if (Questions.useranswers[count][0].equals(Questions.answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            count = 0;
            setVisible(false);
            new Score(name, score);
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
            E.printStackTrace();
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

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (group.getSelection() == null) {
                    Questions.useranswers[count][0] = "";
                } else {
                    Questions.useranswers[count][0] = group.getSelection().getActionCommand();
                }

                for (int i = 0; i < Questions.useranswers.length; i++) {
                    if (Questions.useranswers[i][0].equals(Questions.answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }

                setVisible(false);
                new Score(name, score);

            } else {
                if (group.getSelection() == null) {
                    Questions.useranswers[count][0] = "";
                } else {
                    Questions.useranswers[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText(" " + (count + 1) + ". ");
        question.setText(Questions.questions[count][0]);

        opt1.setText(Questions.questions[count][1]);
        opt1.setActionCommand(Questions.questions[count][1]);

        opt2.setText(Questions.questions[count][2]);
        opt2.setActionCommand(Questions.questions[count][2]);

        opt3.setText(Questions.questions[count][3]);
        opt3.setActionCommand(Questions.questions[count][3]);

        opt4.setText(Questions.questions[count][4]);
        opt4.setActionCommand(Questions.questions[count][4]);

        group.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("Chief");
    }
}
