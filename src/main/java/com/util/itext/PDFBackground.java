package com.util.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBackground extends PdfPageEventHelper {


    @Override
	public
    void onEndPage(PdfWriter writer, Document document) {
    	try {
    		Image background = Image.getInstance("C:\\Users\\Daniel\\Pictures\\back.jpg");
            // This scales the image to the page,
            // use the image's width & height if you don't want to scale.
            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();
            writer.getDirectContentUnder()
	        .addImage(background, width, 0, 0, height, 0, 0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
