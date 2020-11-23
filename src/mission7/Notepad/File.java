package Notepad;

import javax.swing.*;
import java.awt.*;

public class File {
    MenuItem miNew, miOpen, miSave, miSaveAs, miPageSetup, miPrint, miExit;

    File(Menu mFile) {
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSave = new MenuItem("Save");
        miSaveAs = new MenuItem("SaveAs");
        miPageSetup = new MenuItem("PageSetup");
        miPrint = new MenuItem("Print");
        miExit = new MenuItem("Exit");

        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.add(miSaveAs);
        mFile.addSeparator(); // 메뉴 분리선
        mFile.add(miPageSetup);
        mFile.add(miPrint);
        mFile.addSeparator(); // 메뉴 분리선
        mFile.add(miExit);
    }


}
