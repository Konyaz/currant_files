package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipTest {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/1.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "123456789";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "abcdefghi";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }


    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/2.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/2.txt";
        String expectedData = "987654321";

        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }

}