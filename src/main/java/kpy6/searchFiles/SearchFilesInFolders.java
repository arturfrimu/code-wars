package kpy6.searchFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchFilesInFolders {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        String what = "И";
        String dirFrom = "D:\\Artur\\books\\Java_книги_по_программированию\\files";
        String dirTo = "D:\\Artur\\books\\Java_книги_по_программированию\\" + what + "\\";

        searchFiles(new File(dirFrom), fileList, what);

        for (File file : fileList) {
            FileMover.moveFileToOtherDirectory(file, dirTo);
        }
    }

    public static void searchFiles(File rootFile, List<File> fileList, String contains) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList, contains);
                    } else {
                        boolean isPdf = file.getName().toLowerCase(Locale.ROOT).endsWith(".pdf");
                        boolean isAJavaBook = file.getName().toLowerCase(Locale.ROOT).contains(contains.toLowerCase(Locale.ROOT));
                        if (isAJavaBook) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
