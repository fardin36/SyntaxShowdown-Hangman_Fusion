package quiz.app;

import javax.swing.*;
import java.awt.*;

public class ButtonUtils {
    public static JRadioButton newRadioButton(int y) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(110, y, 700, 30);
        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Dialog", Font.PLAIN, 20));
        return opt;
    }

    public static ButtonGroup newButtonGroup(JRadioButton... buttons) {
        ButtonGroup group1 = new ButtonGroup();
        for (JRadioButton button : buttons) {
            group1.add(button);
        }
        return group1;
    }

    public static JButton newJButton(String text, int x, int y, int width, int height, Color bg, Color fg) {
        JButton newJButton = new JButton(text);
        newJButton.setBounds(x, y, width, height);
        newJButton.setBackground(bg);
        newJButton.setForeground(fg);
        return newJButton;
    }
}
