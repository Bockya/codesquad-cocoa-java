package mission8.zetcode;

import javax.swing.*;
import java.awt.*;

public class Image extends JFrame {
    public Image() {
        initUI();
    }

    private void initUI() {
        add(new ImgBoard());
        pack();
        setTitle("Hangeul Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Image ex = new Image();
            ex.setVisible(true);
        });
    }
}
