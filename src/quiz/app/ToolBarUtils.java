package quiz.app;

import quiz.app.ButtonUtils;
import quiz.app.CommonConstants;

import javax.swing.*;

public class ToolBarUtils {

    public static JButton minBtn() {
        return ButtonUtils.newJButton("—", 1190, 0, 46, 25, CommonConstants.PURPLE, CommonConstants.PINK);
    }

    public static JButton exitBtn() {
        return ButtonUtils.newJButton("X", 1235, 0, 45, 25, CommonConstants.PURPLE, CommonConstants.PINK);
    }

    public static JButton backBtn() {
        return ButtonUtils.newJButton("←", 1, 0, 46, 25, CommonConstants.PURPLE, CommonConstants.PINK);
    }

}
