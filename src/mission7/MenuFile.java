package mission7;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MenuFile extends Frame {
    MenuFile() {
        initUI();
        addEvent();
    }

    private void addEvent() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                //Frame 닫기 버튼을 눌렀을 때 호출
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
        MyMenuBar m = new MyMenuBar("Text Editor");
        setTitle("제목 없음 - Windows 메모장");
        setSize(500, 400);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new MenuFile();
            f.setVisible(true);
        });
    }

    private class MyMenuBar {
        String fileName;
        TextArea content;
        MenuBar mb;
        Menu mFile, mEdit, mFormat, mView, mHelp; //MenuBar
        MenuItem miNew, miNewWindow, miOpen, miSave, miSaveAs, miPageSetup, miPrint, miExit; //mFile
        MenuItem miUndo, miCut, miCopy, miPaste, miDelete, miSearchwithBeing, miFind, miFindNext, miFindPrevious, miReplace, miGoTo, miSelectAll, miTimeDate; //mEdit
        MenuItem miFont; //mFormat
        Menu mZoom; //mView
        MenuItem miZoomIn, miZoomOut, miDefaultZoom; //mView
        CheckboxMenuItem miWordWrap, miStatusBar; //mFormat, mView
        MenuItem miViewHelp, miSendFeedback, miAboutNotepad;

        MyMenuBar(String title) {
            content = new TextArea();
            add(content);

            mb = new MenuBar();
            //파일 메뉴
            mFile = new Menu("파일(F)");
            miNew = new MenuItem("새로 만들기(N)");
            miNew.setShortcut(new MenuShortcut(KeyEvent.VK_N)); //ctrl + N
            miOpen = new MenuItem("열기(O)");
            miOpen.setShortcut(new MenuShortcut(KeyEvent.VK_O)); //ctrl + O
            miSaveAs = new MenuItem("다른 이름으로 저장(A)");
            miSaveAs.setShortcut(new MenuShortcut(KeyEvent.VK_S, true)); //ctrl + Shift + s
            miExit = new MenuItem("끝내기(X)");

            //편집 메뉴
            mEdit = new Menu("편집(E)");

            //서식 메뉴
            mFormat = new Menu("서식(O)");
            miWordWrap = new CheckboxMenuItem("자동 줄 바꿈(W)");
            miFont = new MenuItem("글꼴(F)");

            //보기 메뉴
            mView = new Menu("보기(V)");
            mZoom = new Menu("확대하기/축소하기");
            miZoomIn = new MenuItem("확대(I)");
            miZoomIn.setShortcut(new MenuShortcut(KeyEvent.VK_PLUS)); //ctrl + 더하기
            miZoomOut = new MenuItem("축소(O)");
            miZoomOut.setShortcut(new MenuShortcut(KeyEvent.VK_MINUS)); //ctrl + 빼기
            miDefaultZoom = new MenuItem("확대하기/축소하기 기본값 복원");
            miDefaultZoom.setShortcut(new MenuShortcut(KeyEvent.VK_0)); //ctrl + 0
            miStatusBar = new CheckboxMenuItem("상태 표시줄(S)");

            //도움말 메뉴
            mHelp = new Menu("도움말(H)");
            miViewHelp = new MenuItem("도움말 보기(H)");
            miSendFeedback = new MenuItem("피드백 보내기(F)");
            miAboutNotepad = new MenuItem("메모장 정보(A)");

            //mFile에 MenuItem 추가
            mFile.add(miNew);
            mFile.add(miOpen);
            mFile.add(miSaveAs);
            mFile.addSeparator(); //메뉴 분리선
            mFile.add(miExit);

            //mFormat에 MenuItem 추가
            mFormat.add(miWordWrap);
            mFormat.add(miFont);

            //mView에 MenuItem 추가
            mView.add(mZoom);
            mZoom.add(miZoomIn);
            mZoom.add(miZoomOut);
            mZoom.add(miDefaultZoom);
            mView.add(miStatusBar);

            //mHelp에 MenuItem 추가
            mHelp.add(miViewHelp);
            mHelp.add(miSendFeedback);
            mHelp.addSeparator(); //메뉴 분리선
            mHelp.add(miAboutNotepad);

            //Menubar에 Menu를 추가
            mb.add(mFile);
            mb.add(mEdit);
            mb.add(mFormat);
            mb.add(mView);
            mb.setHelpMenu(mHelp); //mHelp를 HelpMenu로 지정

            setMenuBar(mb); //Frame에 MenuBar 포함

            //메뉴 이벤트 핸들러 등록
            EventHandler handler = new EventHandler();
            //mFile
            miNew.addActionListener(handler);
            miExit.addActionListener(handler);
            miSaveAs.addActionListener(handler);
            miOpen.addActionListener(handler);

            //mView
            miZoomIn.addActionListener(handler);
            miZoomOut.addActionListener(handler);
            //miStatusBar.addItemListener(handler2);
        }

        //TextArea 내용을 지정된 파일에 저장하는 메서드
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

                if (cmd.equals("새로 만들기(N)")) {
                    content.setText("");
                    setTitle("제목 없음 - Windows 메모장");
                }
                if (cmd.equals("끝내기(X)"))
                    System.exit(0); //프로그램 종료
                if (cmd.equals("다른 이름으로 저장(A)")) {
                    FileDialog fileSave = new FileDialog(MenuFile.this, "다른 이름으로 저장", FileDialog.SAVE);
                    //fileSave.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileSave.setVisible(true);
                    fileName = fileSave.getDirectory() + fileSave.getFile();
                    System.out.println(fileName);
                    //현재 TextArea 내용을 선택된 파일에 저장
                    saveAs(fileName);
                    setTitle(fileSave.getFile());
                }
                if (cmd.equals("열기(O)")) {
                    FileDialog fileOpen = new FileDialog(MenuFile.this, "열기");
                    //fileOpen.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileOpen.setVisible(true);
                    fileName = fileOpen.getDirectory() + fileOpen.getFile();
                    System.out.println(fileName);
                    //선택된 파일의 내용을 TextArea에 보여줌
                    fileOpen(fileName);
                    setTitle(fileOpen.getFile());
                }
                if (cmd.equals("상태 표시줄(S)")) {
                    setLayout(new BorderLayout());
                    Button south = new Button("South");
                    add(south, "Status Bar");
                }
            }
        }
    }
}
