package com.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;

@Service
public class PdfService {
	
	public Document  createBookPhotos(List<Object[]> datas,String nameBrand,LocalDate initialDate,LocalDate finalDate){
		Document document = new Document(new Rectangle(842,595));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		generateInitialPage(null, null, null, document);
	}
	
	public void generateInitialPage(String nameBrand,LocalDate initialDate, LocalDate finalDate, Document document) throws DocumentException {
	    
		Paragraph brandText =  new Paragraph();
		brandText.add(nameBrand);
		brandText.setAlignment(0);
		
		Paragraph dateText = new Paragraph();
		dateText.add(initialDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" - "+ finalDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    
		
		Paragraph emissionInformationText = new Paragraph();
		emissionInformationText.add("Emitido em: "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    
	    PdfPTable table = new PdfPTable(1);
	    table.setHorizontalAlignment(table.ALIGN_CENTER);
	    table.addCell(new PdfPCell(brandText));
	    table.addCell(new PdfPCell(dateText));
	    
	    emissionInformationText.setAlignment(emissionInformationText.ALIGN_BOTTOM);
	    
	    document.add(emissionInformationText);
	  
	    document.add(table);
	}
	
}
