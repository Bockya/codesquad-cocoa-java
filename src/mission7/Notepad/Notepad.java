package Notepad;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Notepad extends Frame {
    public Notepad() {
        initUI();
        addEvent();
        Menu m = new Menu("Text Editor");
    }

    class Menu {
        String fileName;
        TextArea content;
        MenuBar mb;
        java.awt.Menu mFile, mEdit, mFormat, mView, mHelp;
        java.awt.MenuItem miNew, miOpen, miSaveAs, miExit;

        Menu(String title) {
            mb = new MenuBar();
            mFile = new java.awt.Menu("파일(F)");

            miNew = new MenuItem("새로 만들기(N)");
            miOpen = new MenuItem("열기(O)");
            miSaveAs = new MenuItem("다른 이름으로 저장(A)");
            miExit = new MenuItem("끝내기(X)");

            mEdit = new java.awt.Menu("편집(E)");
            mFormat = new java.awt.Menu("서식(O)");
            mView = new java.awt.Menu("보기(V)");
            mHelp = new java.awt.Menu("도움말(H)");

            //mFile에 MenuItem 추가
            mFile.add(miNew);
            mFile.add(miOpen);
            mFile.add(miSaveAs);
            mFile.addSeparator(); //메뉴 분리선
            mFile.add(miExit);

            //Menubar에 Menu를 추가
            mb.add(mFile);
            mb.add(mEdit);
            mb.add(mFormat);
            mb.add(mView);
            mb.setHelpMenu(mHelp); //mHelp를 HelpMenu로 지정

            setMenuBar(mb); //Frame에 MenuBar 포함
        }
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
        setSize(500, 400);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new Notepad();
            f.setVisible(true);
        });
    }
}
