package Notepad;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Notepad extends Frame{
    public Notepad() {
        initUI();
        addEvent();
    }

    private void addEvent() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) { //Frame의 닫기 버튼을 눌렀을 때 호출
                e.getWindow().setVisible(false); //Frame 화면에서 보이지 않도록 하기
                e.getWindow().dispose(); //메모리에서 제거
                System.exit(0); //프로그램 종료
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void initUI() {
        setTitle("제목 없음 - Windows 메모장");
        setSize(500, 300);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new Notepad();
            f.setVisible(true);
        });
    }
}
