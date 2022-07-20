package com.example.demo.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

@Service
public class ExcelService {
	
	@Autowired
	BookService bookService;
	
	public List<Book> excelBookList(InputStream inputStream){
		List<Book> list = new ArrayList<>();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
			//工作表對象
			XSSFSheet sheet = workbook.getSheetAt(0);
			//總行數
			int rowLength = sheet.getLastRowNum();
			//工作列表
			XSSFRow row = sheet.getRow(0);
			//總列數
			int colLength = row.getLastCellNum();
			
			Cell cell = null;
			for(int i = 0; i <= rowLength; i++) {
				Book bookCell = new Book();
				row = sheet.getRow(i);
				for(int j = 0; j < colLength; j++) {
					cell = row.getCell(j);
					if(j == 0) {
						bookCell.setBookName(cell.getStringCellValue());
					}else if(j == 1) {
						bookCell.setPrice(cell.getNumericCellValue());
					}else if(j == 2) {
						bookCell.setWriter(cell.getStringCellValue());
					}else if(j == 3) {
						bookCell.setBookNumber((int)cell.getNumericCellValue());
					}
				}
				bookService.createBook(bookCell);
				list.add(bookCell);
			}
		}catch(Exception e) {
			
		}
		return list;
	}

}
