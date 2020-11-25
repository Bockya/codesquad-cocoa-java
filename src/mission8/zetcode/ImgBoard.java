package mission8.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class ImgBoard extends JPanel {
    private Image hclock;

    public ImgBoard() {
        initBoard();
    }

    private void initBoard() {
        loadImage();
        int w = hclock.getWidth(this);
        int h = hclock.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("src\\mission8\\resources\\hclock.png");
        hclock = ii.getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(hclock, 0, 0, null);
    }
}
