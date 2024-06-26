package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import quiz.app.CommonConstants.*;

public class ButtonUtils {
    public static JRadioButton newRadioButton(int y, Color fg, Color bg, int actionCommand) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(110, y, 1000, 30);
        opt.setFont(new Font("Consolas", Font.PLAIN, 18));
        opt.setBackground(bg);
        opt.setForeground(fg);
        opt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        opt.setActionCommand(String.valueOf(actionCommand));
        return opt;
    }

    public static JButton newJButton(String text, int x, int y, int width, int height, Color bg, Color fg) {
        JButton newJButton = new JButton(text);
        newJButton.setBounds(x, y, width, height);
        newJButton.setFocusPainted(false);
        newJButton.setBackground(bg);
        newJButton.setForeground(fg);
        newJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        newJButton.setBorder(BorderFactory.createLineBorder(CommonConstants.PINK, 2));
        return newJButton;
    }

    public static JButton newJButton(String imgPath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imgPath));
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JButton newJButton = new JButton(resizedImageIcon);
        newJButton.setBorderPainted(false);
        newJButton.setBounds(x, y, width, height);
        newJButton.setContentAreaFilled(false);
        newJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        newJButton.setBackground(bg);
        return newJButton;
    }

    public static ButtonGroup newButtonGroup(JRadioButton... buttons) {
        ButtonGroup group1 = new ButtonGroup();
        for (JRadioButton button : buttons) {
            group1.add(button);
        }
        return group1;
    }
}


