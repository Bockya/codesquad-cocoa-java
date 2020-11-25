package mission8.zetcode;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board()); //Board to the cnter of the JFrame container
        setSize(250, 200); //size of the window
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when clik on the close button
        setLocationRelativeTo(null); //center the window on the screen
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
