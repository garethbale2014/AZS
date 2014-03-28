package de.rs.firdaous.xml.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;

import de.rs.prototype.firdaous.model.FieldInfoList;
import de.rs.prototype.firdaous.model.IPDFFieldInfo;
import de.rs.prototype.firdaous.model.WorkOrder;

public interface IDocumentService {
	
	public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException, SAXException, DocumentException ;

	void copyPDF(String file) throws IOException, DocumentException;
	
	public void encryptPdf(String src, String dest) throws IOException, DocumentException;
	
	public void setFieldToPDF(FieldInfoList fieldInfoList) throws IOException, ParserConfigurationException, SAXException, DocumentException;
	
	public Map<String, AcroFields.Item>  getPDFFieldMap(String file) throws IOException, ParserConfigurationException, SAXException, DocumentException;

}
