package com.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
@Service
public class ExcelService {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
		
	public byte[] generateRupturaExcel(List<String[]> datas) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		XSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell(0).setCellValue("LOJA");
		rowhead.createCell(1).setCellValue("PRODUTO");
		rowhead.createCell(2).setCellValue("STATUS");
		rowhead.createCell(3).setCellValue("DATA INFORMADA");
		
		int cont = 1;
		for(String[] data : datas) {
			XSSFRow row = sheet.createRow((short) cont++);
            row.createCell(0).setCellValue(data[0]);
            row.createCell(1).setCellValue(data[1]);
            row.createCell(2).setCellValue(data[2]);
		}
		try {
			workbook.write(bos);
			workbook.close();
		}catch (Exception e) {
		}
		return bos.toByteArray();
	}
	
	
	public byte[] generateValidadeExcel(List<String[]> datas) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		XSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell(0).setCellValue("LOJA");
		rowhead.createCell(1).setCellValue("PRODUTO");
		rowhead.createCell(2).setCellValue("VALIDADE");
		rowhead.createCell(3).setCellValue("ESTOQUE");
		rowhead.createCell(4).setCellValue("DATA INFORMADA");
		int cont = 1;
		for(String[] data : datas) {
			XSSFRow row = sheet.createRow((short) cont++);
            row.createCell(0).setCellValue(data[2]);
            row.createCell(1).setCellValue(data[1]);
            row.createCell(2).setCellValue(Date.from(LocalDate.parse(data[3]).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            row.createCell(3).setCellValue(data[4]);
            row.createCell(4).setCellValue(Date.from(LocalDate.parse(data[0]).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		}
		try {
			workbook.write(bos);
			workbook.close();
		}catch (Exception e) {
		}
		return bos.toByteArray();
	}
	
}
