package kpy6.searchFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchFilesInFolders {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        searchFiles(new File("D:\\Artur\\books"), fileList);
        fileList.forEach(file -> System.out.println(file.getAbsolutePath()));
    }

    public static void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        boolean isPdf = file.getName().toLowerCase(Locale.ROOT).endsWith(".pdf");
                        boolean isAJavaBook = file.getName().toLowerCase(Locale.ROOT).contains("java");
                        if (isPdf && isAJavaBook) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
