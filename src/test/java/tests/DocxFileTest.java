
package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromDocxPath;


public class DocxFileTest {


    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/files/1.docx";
        String expectedData = "abcdefghi";

        String actualData = readTextFromDocxPath(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}