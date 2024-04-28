package quiz.app;

import javax.swing.*;

public class HangmanUtils {

    static JLabel imageLabel;
    static int currentImageIndex = 0;
    private static final String[] imagePaths = {
            "resources/image1.png", "resources/image2.png", "resources/image3.png", "resources/image4.png",
            "resources/image5.png", "resources/image6.png", "resources/image7.png"
    };

    public static JLabel addHang(){
        imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
        imageLabel.setBounds(0,0,1280,300);
        return imageLabel;
    }

    public static void updateImage() { // Assuming initial state
        currentImageIndex++;
        if (currentImageIndex >= imagePaths.length) {
            currentImageIndex = 0;
        }
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
    }
}
