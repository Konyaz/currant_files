package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromDocxPath;
import static utils.Files.readTextFromPath;

public class DocFileTest {
    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/files/1.doc";
        String expectedData = "This is Heading1 Text";

        String actualData = readTextFromDocxPath(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

}
