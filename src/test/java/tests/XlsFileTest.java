package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getXls;


public class XlsFileTest {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "abcdefghi";

        XLS xls = new XLS(new File((xlsFilePath)));
        assertThat(xls, XLS.containsText(expectedData));
    }
//начало отсчёта от ноля. getSheetAt( ) - лист, getRow( ) - вертикально,цыфры, getCell( ) - горизонтально,буквы
        @Test
        void xlsCellTest () throws IOException {
            String xlsFilePath = "./src/test/resources/files/1.xls";
            String expectedData = "abcdefghi";

            XLS xls = getXls(xlsFilePath);
            String actualData = xls.excel.getSheetAt(0).getRow(3).getCell(2).toString();
            assertThat(actualData, containsString(expectedData));
        }
    }

