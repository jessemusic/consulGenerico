package br.com.mattec.consul.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;


public class CodigoBarras {
	
	public static void main(String[] args) {
		
		Document doc = new Document();
		try {
			PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigos.pdf"));
			doc.open();
			Barcode39 code = new Barcode39();
			code.setCode("1234567890");
			Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
			
			doc.add(img);
			
			doc.add(new Paragraph(" "));
			
			Barcode128 code128 = new Barcode128();
			code128.setCode("1234567890");
			Image img128 = code128.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
			doc.add(img128);
			
			doc.close();
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}
		
		
	}
	

}
