package ReadWriteDataFromExcel;



import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by pravin.kumbhare on 24-07-2018.
 */
public class ReadExcelFile {


    public void readExcel() throws BiffException, IOException {
        String filePath = "D:\\Solaris Project\\solaris\\Appium_Android_Project\\logger\\Employee_Credential.xlsx";
        File file = new File(filePath);
        jxl.Workbook wb = jxl.Workbook.getWorkbook(file);

        // TO get the access to the sheet
        Sheet sh = wb.getSheet("Sheet1");

        // To get the number of rows present in sheet
        int totalNoOfRows = sh.getRows();

        // To get the number of columns present in sheet
        int totalNoOfCols = sh.getColumns();

        for (int row = 0; row < totalNoOfRows; row++) {

            for (int col = 0; col < totalNoOfCols; col++) {
                System.out.print(sh.getCell(col, row).getContents() + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String args[]) throws BiffException, IOException {
        ReadExcelFile DT = new ReadExcelFile();
        DT.readExcel();
    }

}
