package quiz.app;

import javax.swing.*;

public class HangmanUtils {

    static JLabel imageLabel;
    static int currentImageIndex = 0;
    static boolean isReset = false;
    private static final String[] imagePaths = {
            "resources/image1.png", "resources/image2.png", "resources/image3.png", "resources/image4.png",
            "resources/image5.png", "resources/image6.png", "resources/image7.png" , "resources/image8.png"
    };

    public static JLabel addHang() {
        imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
        imageLabel.setBounds(0, 0, 1280, 300);
        return imageLabel;
    }

    public static void updateImage() { // Assuming initial state
        currentImageIndex++;
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
        if (currentImageIndex == imagePaths.length - 1) {
            currentImageIndex = 0;
            setIsReset();
        }
    }

    public static void undoUpdateImage() {
        currentImageIndex--;
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
    }

    public static boolean getIsReset() {
        return isReset;
    }

    public static void setIsReset() {
        isReset = !isReset;
    }

    public static int getCurrentImageIndex() {
        return currentImageIndex;
    }

    public static void resetImageIndex(){
        currentImageIndex = 0;
    }
}
