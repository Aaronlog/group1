package com.offcn.controller;


import com.offcn.bean.Customer;
import com.offcn.service.CustomerService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CustController{

    @Resource
    CustomerService cusce;

//  将xlsx文件的数据导入数据库中
    @RequestMapping("/saveCust")
    public String saveCust(MultipartFile excel) throws Exception {
//        获得资源文件的路径，输入流
        InputStream is = excel.getInputStream();
//        放入到XSSFWorkbook中
        XSSFWorkbook sheets = new XSSFWorkbook(is);
//        获取第一页
        XSSFSheet sheetAt = sheets.getSheetAt(0);
//       获取物理行数
        int pr = sheetAt.getPhysicalNumberOfRows();
        for (int i=1;i<pr;i++){
            XSSFRow row = sheetAt.getRow(i);
            XSSFCell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String id = cell.getStringCellValue();
            XSSFCell cellb = row.getCell(1);
            String name = cellb.getStringCellValue();
            XSSFCell cellc = row.getCell(2);
            Date date = cellc.getDateCellValue();
            Customer cus = new Customer();
            cus.setCus_id(Integer.parseInt(id));
            cus.setCname(name);
            cus.setDate(date);
            cusce.saveCust(cus);
        }

        return "redirect:/getCust.action";
    }

    @RequestMapping("/getCust")
    public String getCust(Customer cus, Model model){
        List<Customer> cust = cusce.getCust();
        model.addAttribute("cust",cust);
        return "success";
    }

    @RequestMapping("/exc")
    public @ResponseBody String exc(){
        List<Customer> cust = cusce.getCust();
        XSSFWorkbook sheets = new XSSFWorkbook();
        XSSFSheet sheet = sheets.createSheet();
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("ID");
        row1.createCell(1).setCellValue("name");
        for (int i=0;i<cust.size();i++){
            XSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(cust.get(i).getCus_id());
            row.createCell(1).setCellValue(cust.get(i).getCname());
        }
        try{
                FileOutputStream fos = new FileOutputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
                sheets.write(fos);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
    
}
