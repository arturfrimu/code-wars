package kpy6.searchFiles;

import java.awt.*;
import java.io.File;

public class OpenFiles {
    public static void openFile(File file) {
        try {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
