package de.rs.firdaous.services;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;

import de.rs.firdaous.model.WorkOrder;



public interface IDocumentService {
	
	public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException, SAXException, DocumentException ;

	void copyPDF(String file) throws IOException, DocumentException;
	
	public void encryptPdf(String src, String dest) throws IOException, DocumentException;
	
	public void setFieldToPDF(de.rs.firdaous.model.FieldInfoList fieldInfoList) throws IOException, ParserConfigurationException, SAXException, DocumentException;
	
	public Map<String, AcroFields.Item>  getPDFFieldMap(String file) throws IOException, ParserConfigurationException, SAXException, DocumentException;
	
	public void setFieldToPDF(WorkOrder order) throws IOException, ParserConfigurationException, SAXException, DocumentException;
}
