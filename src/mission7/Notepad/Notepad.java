package Notepad;

import java.awt.*;

class Notepad extends Frame {
    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile, mEdit, mFormat, mView, mHelp;
    MenuItem miNew, miOpen, miSave, miSaveAs, miPageSetup, miPrint, miExit;

    Notepad(String title) {
        super(title);
        content = new TextArea();
        add(content);

        mb = new MenuBar();

        mFile = new Menu("File");
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSave = new MenuItem("Save");
        miSaveAs = new MenuItem("SaveAs");
        miPageSetup = new MenuItem("PageSetup");
        miPrint = new MenuItem("Print");
        miExit = new MenuItem("Exit");

        mEdit = new Menu("Edit");
        mFormat = new Menu("Format");
        mView = new Menu("View");
        mHelp = new Menu("Help");

        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.add(miSaveAs);
        mFile.addSeparator(); // 메뉴 분리선
        mFile.add(miPageSetup);
        mFile.add(miPrint);
        mFile.addSeparator(); // 메뉴 분리선
        mFile.add(miExit);

        mb.add(mFile); // MenuBar에 Menu 추가
        mb.add(mEdit); // MenuBar에 Edit 추가
        mb.add(mFormat); // MenuBar에 Format 추가
        mb.add(mView); // MenuBar에 View 추가
        mb.add(mHelp); // MenuBar에 Help 추가

        setMenuBar(mb); // Frame에 MenuBar 포함
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        Notepad np = new Notepad("untitled - Notepad");
    }
}
