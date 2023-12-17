package kpy6;

import java.io.File;

public class FileMover {
    public static void moveFileToOtherDirectory(File file, String to) {
        if (!new File(to).exists()) {
            new File(to).mkdir();
        }
        File dest = new File(to + file.getName());
        if (file.renameTo(dest)) {
            file.delete();
        }

    }
}
