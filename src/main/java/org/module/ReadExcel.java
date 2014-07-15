package org.module;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException{
		String fileName = "E:/read.xls";
		String outFile = "E:/file.txt";
		
		PrintWriter pw = new PrintWriter(outFile);
		
		boolean isE2007 = false;    //判断是否是excel2007格式  
        if(fileName.endsWith("xlsx"))  
            isE2007 = true;  
        try {  
            InputStream input = new FileInputStream(fileName);  //建立输入流  
            Workbook wb  = null;  
            //根据文件格式(2003或者2007)来初始化  
            if(isE2007)  {}
                //  wb = new XSSFWorkbook(input);  
            else  
                wb = new HSSFWorkbook(input);  
            Sheet sheet = wb.getSheetAt(2);     //获得第3个表单  
            Iterator<Row> rows = sheet.rowIterator(); //获得第3个表单的迭代器  
            while (rows.hasNext()) {  
                Row row = rows.next();  //获得行数据  
                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始  
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器  
                
                StringBuffer sb = new StringBuffer();
        		sb.append("INSERT INTO CC.`CC_REQ_REQTYPE` VALUES(");
                
                while (cells.hasNext()) { 
                	
                	System.out.print("================");
                	
                    Cell cell = cells.next();
                    
                    System.out.println("Cell #" + cell.getColumnIndex());  
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据 
                    
                    case HSSFCell.CELL_TYPE_NUMERIC:  
                    	
                    	sb.append("\'");
                    	sb.append(Integer.toString((int)cell.getNumericCellValue()));
                    	sb.append("\',");
                    	
                        System.out.println(cell.getNumericCellValue());  
                        break;
                        
                        
                    case HSSFCell.CELL_TYPE_STRING:  
                    	
                    	sb.append("\'");
                    	sb.append(cell.getStringCellValue());
                    	sb.append("\',");
                    	
                        System.out.println(cell.getStringCellValue());  
                        break;  
                    case HSSFCell.CELL_TYPE_BOOLEAN:  
                        System.out.println(cell.getBooleanCellValue());  
                        throw new IllegalArgumentException();
                    case HSSFCell.CELL_TYPE_FORMULA:  
                        System.out.println(cell.getCellFormula());  
                        throw new IllegalArgumentException();
                    default:  
                    	sb.append("NULL");
                    	sb.append(",");
                    break;  
                    }  
                    
                    if(cell.getColumnIndex() == 10){
                    	sb.append("NULL");
                    	sb.append(",");
                    }
                    
                    
                } 
                
                sb.append("NULL");
            	sb.append(",");
            	
            	sb.append("NULL");
            	sb.append(",");
                
                sb.deleteCharAt((sb.toString()).length() - 1);
                sb.append(");\r\n");
                pw.write(sb.toString());
                pw.flush();
            }
            pw.close();
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
	}
}
