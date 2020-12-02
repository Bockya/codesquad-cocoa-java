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
                //Frame �ݱ� ��ư�� ������ �� ȣ��
                e.getWindow().setVisible(false); //Frame ȭ�鿡�� ������ �ʵ��� �ϱ�
                e.getWindow().dispose(); //�޸𸮿��� ����
                System.exit(0); //���α׷� ����
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
        setTitle("���� ���� - Windows �޸���");
        setSize(500, 600);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new MenuFile();
            f.setVisible(true);
        });
    }

    private class MyMenuBar {
        String fileName, copiedText;
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
            //���� �޴�
            mFile = new Menu("����(F)");
            miNew = new MenuItem("���� �����(N)");
            miNew.setShortcut(new MenuShortcut(KeyEvent.VK_N)); //ctrl + N
            miOpen = new MenuItem("����(O)");
            miOpen.setShortcut(new MenuShortcut(KeyEvent.VK_O)); //ctrl + O
            miSaveAs = new MenuItem("�ٸ� �̸����� ����(A)");
            miSaveAs.setShortcut(new MenuShortcut(KeyEvent.VK_S, true)); //ctrl + Shift + s
            miExit = new MenuItem("������(X)");

            //���� �޴�
            mEdit = new Menu("����(E)");
            miUndo = new MenuItem("���� ���(U)");
            miCut = new MenuItem("�߶󳻱�(T)");
            miCopy = new MenuItem("����(C)");
            miPaste = new MenuItem("�ٿ��ֱ�(P)");
            miDelete = new MenuItem("����(L)");
            miSearchwithBeing = new MenuItem("Bing���� �˻�(S)...");
            miFind = new MenuItem("ã��(F)...");
            miFindNext = new MenuItem("���� ã��(N)");
            miFindPrevious = new MenuItem("���� ã��(V)");
            miReplace = new MenuItem("�ٲٱ�(R)...");
            miGoTo = new MenuItem("�̵�(G)...");
            miSelectAll = new MenuItem("��� ����(A)");
            miTimeDate = new MenuItem("�ð�/��¥(D)");

            //���� �޴�
            mFormat = new Menu("����(O)");
            miWordWrap = new CheckboxMenuItem("�ڵ� �� �ٲ�(W)");
            miFont = new MenuItem("�۲�(F)");

            //���� �޴�
            mView = new Menu("����(V)");
            mZoom = new Menu("Ȯ���ϱ�/����ϱ�");
            miZoomIn = new MenuItem("Ȯ��(I)");
            miZoomIn.setShortcut(new MenuShortcut(KeyEvent.VK_PLUS)); //ctrl + ���ϱ�
            miZoomOut = new MenuItem("���(O)");
            miZoomOut.setShortcut(new MenuShortcut(KeyEvent.VK_MINUS)); //ctrl + ����
            miDefaultZoom = new MenuItem("Ȯ���ϱ�/����ϱ� �⺻�� ����");
            miDefaultZoom.setShortcut(new MenuShortcut(KeyEvent.VK_0)); //ctrl + 0
            miStatusBar = new CheckboxMenuItem("���� ǥ����(S)");

            //���� �޴�
            mHelp = new Menu("����(H)");
            miViewHelp = new MenuItem("���� ����(H)");
            miSendFeedback = new MenuItem("�ǵ�� ������(F)");
            miAboutNotepad = new MenuItem("�޸��� ����(A)");

            //mFile�� MenuItem �߰�
            mFile.add(miNew);
            mFile.add(miOpen);
            mFile.add(miSaveAs);
            mFile.addSeparator(); //�޴� �и���
            mFile.add(miExit);

            //mEdit�� MenuItem �߰�
            mEdit.add(miUndo);
            mEdit.addSeparator();
            mEdit.add(miCut);
            mEdit.add(miCopy);
            mEdit.add(miPaste);
            mEdit.add(miDelete);
            mEdit.addSeparator();
            mEdit.add(miSearchwithBeing);
            mEdit.add(miFind);
            mEdit.add(miFindNext);
            mEdit.add(miFindPrevious);
            mEdit.add(miReplace);
            mEdit.add(miGoTo);
            mEdit.addSeparator();
            mEdit.add(miSelectAll);
            mEdit.add(miTimeDate);

            //mFormat�� MenuItem �߰�
            mFormat.add(miWordWrap);
            mFormat.add(miFont);

            //mView�� MenuItem �߰�
            mView.add(mZoom);
            mZoom.add(miZoomIn);
            mZoom.add(miZoomOut);
            mZoom.add(miDefaultZoom);
            mView.add(miStatusBar);

            //mHelp�� MenuItem �߰�
            mHelp.add(miViewHelp);
            mHelp.add(miSendFeedback);
            mHelp.addSeparator(); //�޴� �и���
            mHelp.add(miAboutNotepad);

            //Menubar�� Menu�� �߰�
            mb.add(mFile);
            mb.add(mEdit);
            mb.add(mFormat);
            mb.add(mView);
            mb.setHelpMenu(mHelp); //mHelp�� HelpMenu�� ����

            setMenuBar(mb); //Frame�� MenuBar ����

            //�޴� �̺�Ʈ �ڵ鷯 ���
            EventHandler handler = new EventHandler();
            //mFile
            miNew.addActionListener(handler);
            miExit.addActionListener(handler);
            miSaveAs.addActionListener(handler);
            miOpen.addActionListener(handler);

            //mEdit
            miUndo.addActionListener(handler);
            miCut.addActionListener(handler);
            miCopy.addActionListener(handler);
            miPaste.addActionListener(handler);
            miDelete.addActionListener(handler);
            miSearchwithBeing.addActionListener(handler);
            miFind.addActionListener(handler);
            miFindNext.addActionListener(handler);
            miFindPrevious.addActionListener(handler);
            miReplace.addActionListener(handler);
            miGoTo.addActionListener(handler);
            miSelectAll.addActionListener(handler);
            miTimeDate.addActionListener(handler);

            //mView
            miZoomIn.addActionListener(handler);
            miZoomOut.addActionListener(handler);
            //miStatusBar.addItemListener(handler2);
        }

        //TextArea ������ ������ ���Ͽ� �����ϴ� �޼���
        void saveAs(String fileName) {
            FileWriter fw;
            BufferedWriter bw;

            try {
                fw = new FileWriter(fileName);
                bw = new BufferedWriter(fw);
                bw.write(content.getText()); //TextArea ���� ����
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //���õ� ������ ������ �о TextArea�� �����ִ� �޼���
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

        //�޴��� Ŭ������ �� �޴��� ó���ڵ�
        class EventHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                if (e.getSource() == miNew) {
                    content.setText("");
                    setTitle("���� ���� - Windows �޸���");
                }
                if (e.getSource() == miExit)
                    System.exit(0); //���α׷� ����
                if (e.getSource() == miSaveAs) {
                    FileDialog fileSave = new FileDialog(MenuFile.this, "�ٸ� �̸����� ����", FileDialog.SAVE);
                    //fileSave.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileSave.setVisible(true);
                    fileName = fileSave.getDirectory() + fileSave.getFile();
                    System.out.println(fileName);
                    //���� TextArea ������ ���õ� ���Ͽ� ����
                    saveAs(fileName);
                    setTitle(fileSave.getFile());
                }
                if (e.getSource() == miOpen) {
                    FileDialog fileOpen = new FileDialog(MenuFile.this, "����");
                    //fileOpen.setDirectory("C:\\Users\\HEE GYEONG\\IdeaProjects\\codesquad_cocoa\\res");
                    fileOpen.setVisible(true);
                    fileName = fileOpen.getDirectory() + fileOpen.getFile();
                    System.out.println(fileName);
                    //���õ� ������ ������ TextArea�� ������
                    fileOpen(fileName);
                    setTitle(fileOpen.getFile());
                }
                if (e.getSource() == miCopy) {
                    copiedText = content.getSelectedText(); //���õ� �κи� ����
                    System.out.println(copiedText);
                }
                if (cmd.equals("���� ǥ����(S)")) {
                    setLayout(new BorderLayout());
                    Button south = new Button("South");
                    add(south, "Status Bar");
                }
            }
        }
    }
}
