package de.rs.pdf.test;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface IDocumentServiceTest {
	
	public void encryptPdf(String src, String dest) throws IOException, DocumentException ;
}
