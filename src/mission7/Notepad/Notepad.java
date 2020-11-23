package Notepad;

import java.awt.*;

class Notepad extends Frame {
    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile, mEdit, mFormat, mView, mHelp;

    Notepad(String title) {
        super(title);
        content = new TextArea();
        add(content);

        mb = new MenuBar();

        mFile = new Menu("File");
        File f = new File(mFile);
        mEdit = new Menu("Edit");
        mFormat = new Menu("Format");
        mView = new Menu("View");
        mHelp = new Menu("Help");

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
