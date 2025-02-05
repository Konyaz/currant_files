package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.hwpf.HWPFDocument;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

//Txt & Csv
public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readTextFromPath(String path) throws IOException {
        return readTextFromFile(getFile(path));
    }


    public static File getFile(String path) {
        return new File(path);
    }
    //Pdf
    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));

    }

    //Doc&Docx
public static String readTextFromDocxPath(String path) throws IOException {
    if (path.endsWith("doc")) {
        FileInputStream fileInputStream = new FileInputStream(getFile(path));
        HWPFDocument document = new HWPFDocument(fileInputStream);
        WordExtractor extractor = new WordExtractor(document);
        return extractor.getText();
    } else if (path.endsWith("docx")) {
        FileInputStream fileInputStream = new FileInputStream(getFile(path));
        XWPFDocument document = new XWPFDocument(fileInputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        return extractor.getText();
    } else {
        throw new IllegalArgumentException("The specified file is not a Word file");
    }
}

    //Xlsx & Xls
    public static XLS getXls(String path) throws IOException {
        return new XLS(getFile(path));
    }

    public static String readXlsxFromPath(String path) {
        String result = "";
        XSSFWorkbook myExcelBook = null;


        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Iterator<Row> rows = myExcelSheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
//                    case Cell.CELL_TYPE_STRING:
//                        result += cell.getStringCellValue() + "=";
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
//
//                    case Cell.CELL_TYPE_FORMULA:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
                    default:
                        result += cell.toString();
                        break;
                }
            }
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
