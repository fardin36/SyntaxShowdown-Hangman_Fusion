package quiz.app;

import javax.swing.*;
import java.awt.*;

import quiz.app.CommonConstants.*;

public class ButtonUtils {
    public static JRadioButton newRadioButton(int y, Color fg, Color bg, int actionCommand) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(110, y, 1000, 30);
        opt.setFont(new Font("Dialog", Font.PLAIN, 18));
        opt.setBackground(bg);
        opt.setForeground(fg);
        opt.setActionCommand(String.valueOf(actionCommand));
        return opt;
    }

    public static JButton newJButton(String text, int x, int y, int width, int height, Color bg, Color fg) {
        JButton newJButton = new JButton(text);
        newJButton.setBounds(x, y, width, height);
        newJButton.setBackground(bg);
        newJButton.setForeground(fg);
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
