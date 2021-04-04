package tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getDoc;


public class DocFileTest {

    @Test
    void docTest() throws IOException, InvalidFormatException {
        String docxFilePath = "./src/test/resources/files/1.doc";
        String expectedData = "This is Heading1 Text";
        String actualData = getDoc(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}