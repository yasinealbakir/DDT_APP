package ddt.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class BaseCollection {

    public static final String FILE_PATH = "C:\\\\selenium-driver\\\\liste.xls";
    public static final String FILE_PATH_LOGIN = "C:\\\\selenium-driver\\\\user-list.xls";
    public static final String LOGIN_URL = "https://demo.yasinalbakir.net";

    //CSV Reader
    public static List<String[]> csvRead(String file) {
        List<String[]> data = new ArrayList<>();
        String row;

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            while ((row = buffer.readLine()) != null) {
                String[] line = row.split(",");
                data.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found." + ex);
        } catch (IOException ex) {
            System.out.println("File not read." + ex);
        }

        return data;
    }

    //Excel reader
    public static String[][] xlsRead(String fileName) {
        String[][] dataTable = null;
        File file = new File(fileName);
        try {
            FileInputStream xlFile = new FileInputStream(file);
            HSSFWorkbook xlwb = new HSSFWorkbook(xlFile);
            HSSFSheet xlSheet = xlwb.getSheetAt(0);

            int numRows = xlSheet.getLastRowNum() + 1;
            int numCols = xlSheet.getRow(0).getLastCellNum();

            dataTable = new String[numRows][numCols];

            for (int i = 0; i < numRows; i++) {
                HSSFRow xlRow = xlSheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    HSSFCell xlCell = xlRow.getCell(j);
                    dataTable[i][j] = xlCell.toString();
                }

            }

        } catch (IOException ex) {
            System.out.println("ERROR FILE HANDLING" + ex.toString());

        }
        return dataTable;
    }
}
