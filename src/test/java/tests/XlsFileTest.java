package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class XlsFileTest {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "123456789";

        XLS xls = new XLS(new File((xlsFilePath)));
        assertThat(xls, XLS.containsText(expectedData));


    }

}
