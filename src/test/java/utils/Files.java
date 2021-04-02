package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Files {
    public static String readTextFromFile(File file) {
        String fileContent = "";
        try {
            fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public static String readTextFromFilePath(String path) {

        return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {
        return new File(path);


    }
}