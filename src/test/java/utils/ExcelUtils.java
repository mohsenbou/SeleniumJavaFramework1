package utils;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static String projectPath=null;
    static XSSFWorkbook workbook= null;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static int getRowCount(){
        int rowCount = 0;
        try {
            rowCount=sheet.getPhysicalNumberOfRows();
            System.out.println("no of row: "+rowCount);
            return  rowCount;

        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount(){
        int colCount=0;
        
        try {
            colCount=sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("no of columns: "+colCount);
            return colCount;

        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }

    public static String getCellDataString(int rownum, int colnum){
        String cellData = null;
        try {
            cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
//            System.out.println("cellDataString: "+cellData);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }

    public static void getCellDataNum(int rownum, int colnum){
        try {
            double cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
            System.out.println("cellDataNum: "+cellData);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
