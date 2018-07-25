package com.offcn.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PoiController {

    public static void main1(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        XSSFWorkbook sheets = new XSSFWorkbook();
        XSSFSheet sheet = sheets.createSheet();
        XSSFRow row = sheet.createRow(2);
        XSSFCell cell = row.createCell(2);
        cell.setCellValue("测试");
        sheets.write(fos);
    }

    public static void main2(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        XSSFWorkbook sheets = new XSSFWorkbook(fis);
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(2);
        XSSFCell cell = row.getCell(2);
        String s = cell.getStringCellValue();
        System.out.println(s);
    }

    public static void main3(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        Workbook sheets = WorkbookFactory.create(fis);
        Sheet sheetAt = sheets.getSheetAt(0);
        Row row = sheetAt.getRow(2);
        Cell cell = row.getCell(2);
        String s = cell.getStringCellValue();
        System.out.println(s);
    }

    public static void main4(String[] args) throws Exception{
        String path="C:\\Users\\ibm\\Desktop\\demo.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook sheets = new XSSFWorkbook(fis);
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        int pr = sheetAt.getPhysicalNumberOfRows();
        for (int i=0;i<pr;i++){
            XSSFRow row = sheetAt.getRow(i);
            int pc = row.getPhysicalNumberOfCells();
            for (int j=0;j<pc;j++){
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String s = cell.getStringCellValue();
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }

}
