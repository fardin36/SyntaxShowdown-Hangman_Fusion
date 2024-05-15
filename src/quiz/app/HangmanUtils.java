package quiz.app;

import javax.swing.*;

public class HangmanUtils {

    JLabel imageLabel;
    int currentImageIndex = 0;
    boolean isReset = false;
    private static final String[] imagePaths = {
            "resources/image1.png", "resources/image2.png", "resources/image3.png", "resources/image4.png",
            "resources/image5.png", "resources/image6.png", "resources/image7.png" , "resources/image8.png"
    };

    public JLabel addHang() {
        imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
        imageLabel.setBounds(0, 0, 1280, 300);
        return imageLabel;
    }

    public void updateImage() { // Assuming initial state
        currentImageIndex++;
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
        if (currentImageIndex == imagePaths.length - 1) {
            currentImageIndex = 0;
            setIsReset();
        }
    }

    public void undoUpdateImage() {
        currentImageIndex--;
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex])));
    }

    public boolean getIsReset() {
        return isReset;
    }

    public void setIsReset() {
        isReset = !isReset;
    }

    public int getCurrentImageIndex() {
        return currentImageIndex;
    }

    public void resetImageIndex(){
        currentImageIndex = 0;
    }
}
