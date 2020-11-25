package mission8.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Board extends JPanel {
    public void paintComponent(Graphics g) { //painting
        super.paintComponent(g);
        drawDount(g);
    }

    private void drawDount(Graphics g) { //delegate the actual painting to a specific method
        //The Graphics2D class extends the Graphics class
        //It provides more sophisticated control
        //over geometry, coordinate transformations, colour management, and text layout.
        Graphics2D g2d = (Graphics2D) g;
        //RenderingHints: make drawing smooth
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        //to center the dounut shaple on the window
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        //create the ellipse
        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        //ellipse is ratated 72 times to create a donut shape
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
}
