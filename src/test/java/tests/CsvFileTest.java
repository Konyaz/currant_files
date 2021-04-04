package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class CsvFileTest {
    @Test
    void csvTest() throws IOException {
        String csvFilePath = "./src/test/resources/files/1.csv";
        String expectedData = "abcdefghi";

        String actualData = readTextFromPath(csvFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}

