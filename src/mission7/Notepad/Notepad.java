package Notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

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
            content = new TextArea();
            add(content);

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

            //메뉴 이벤트 핸들러 등록
            EventHandler handler = new EventHandler();
            miNew.addActionListener(handler);
            miExit.addActionListener(handler);
            miSaveAs.addActionListener(handler);
            miOpen.addActionListener(handler);
        }

        //TextArea의 내용을 지정된 파일에 저장하는 메서드
        void saveAs(String fileName) {
            FileWriter fw;
            BufferedWriter bw;

            try {
                fw = new FileWriter(fileName);
                bw = new BufferedWriter(fw);
                bw.write(content.getText()); //TextArea 내용 저장
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //선택된 파일의 내용을 읽어서 TextArea에 보여주는 메서드
        void fileOpen(String fileName) {
            FileReader fr;
            BufferedReader br;
            StringWriter sw;

            try {
                fr = new FileReader(fileName);
                br = new BufferedReader(fr);
                sw = new StringWriter();

                int ch;
                //byte[] buffer = new byte[512];
                while ((ch = br.read()) != -1)
                    sw.write(ch);
                br.close();
                content.setText(sw.toString());
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

        //메뉴를 클릭했을 때 메뉴별 처리코드
        class EventHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                if (cmd.equals("새로 만들기(N)"))
                    content.setText("");
                if (cmd.equals("끝내기(X)"))
                    System.exit(0); //프로그램 종료
                if (cmd.equals("다른 이름으로 저장(A)")) {
                    FileDialog fileSave = new FileDialog(Notepad.this, "다른 이름으로 저장", FileDialog.SAVE);
                    fileSave.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileSave.setVisible(true);
                    fileName = fileSave.getDirectory() + fileSave.getFile();
                    System.out.println(fileName);
                    //현재 TextArea의 내용을 선택된 파일에 저장
                    saveAs(fileName);
                }
                if(cmd.equals("열기(O)")){
                    FileDialog fileOpen = new FileDialog(Notepad.this,"열기");
                    fileOpen.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileOpen.setVisible(true);
                    fileName = fileOpen.getDirectory() + fileOpen.getFile();
                    System.out.println(fileName);
                    //선택된 파일의 내용을 TextArea에 보여줌
                    fileOpen(fileName);
                }

            }
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
