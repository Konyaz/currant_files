package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Download_FileTest {

    @Test
    void selenideDownloadReadmeTest() throws IOException {

        Configuration.downloadsFolder = "./downloads";

        String expectedText = "Selenide = UI Testing Framework powered by Selenium WebDriver";

        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);

        assertThat(fileContent, containsString(expectedText));

        //удаление папки downloads после срабатывания теста
        FileUtils.deleteDirectory(new File("./downloads"));

    }
}
