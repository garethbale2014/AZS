package de.rs.firdaous.service;

import java.io.File;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import de.rs.firdaous.xml.services.DocumentService;
import de.rs.firdaous.xml.services.IDocumentService;
import de.rs.firdaous.xml.services.IXMLService;
import de.rs.firdaous.xml.services.ProjectList;
import de.rs.firdaous.xml.services.XMLService;
import de.rs.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class TestFirdaousService {
	
	private WorkOrder order;


	@Before
	public void setUp(){
		
		IXMLService xmlIxmlService = XMLService.getxmlService();
		try {
			ProjectList projectList = xmlIxmlService.loadProjectList();
			if(projectList.getProjectList().size() > 0){
				order = projectList.getProjectList().get(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void setField_ShowFieldValue(){
		IDocumentService instance = DocumentService.getInstance();
		try {
			instance.setFieldToPDF(order, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
