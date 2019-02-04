package com.crm.utils;

import com.crm.base.BaseTest;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileInputStream;

public class TestUtil extends BaseTest {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    static Workbook book;
    static Sheet sheet;


    public static void switchToPanel() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        try {
            FileInputStream file = new FileInputStream(projectPath +
                    "\\src\\main\\java\\com\\crm\\testdata\\FreeCRMTestData.xlsx");
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;


    }


}
