package com.testng.week5.day4.excelintegration;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {

    public static String[][] readDataFromExcel(String fileName) throws IOException {
        //File path
        String filePath = "./data/"+fileName+".xlsx";
        //Create workbook
        XSSFWorkbook workBook = new XSSFWorkbook(filePath);
    int sheetCount = workBook.getNumberOfSheets();
    for(int i=0; i< sheetCount;i++)
    {
        System.out.println(workBook.getSheetName(i));
    }

        //Get sheet
       XSSFSheet sheet = workBook.getSheet("Sheet1");
       //Row and Column count
       int totalRowCount = sheet.getLastRowNum();
       int totalCellCount = sheet.getRow(0).getLastCellNum();

       String[][] data = new String[totalRowCount][totalCellCount];
       //Loop through rows
       for(int i=1; i<=totalRowCount; i++)
       {
        System.out.print("|");

        //Loo through columns
        for(int j=0; j<totalCellCount; j++)
        {
             data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            System.out.print(data[i-1][j] + "|");
            //System.out.printf("%-15s | ", data);
        }
       System.out.println(); // new line

       }
       workBook.close();
       return data;

    }
}


