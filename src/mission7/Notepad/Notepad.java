package Notepad;

import java.awt.*;

public class Notepad extends Frame{
    public Notepad() {
        initUI();
    }

    private void initUI() {
        setTitle("제목 없음 - Windows 메모장");
        setSize(300, 200);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new Notepad();
            f.setVisible(true);
        });
    }
}
