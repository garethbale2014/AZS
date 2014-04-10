package de.rs.firdaous.xml.services;

import java.io.IOException;


import javax.xml.bind.JAXBException;



public interface IXMLService {
	public void saveProjects(de.rs.firdaous.model.WorkOrder workOrder) throws IOException;
	
	
	public ProjectList loadProjectList() throws IOException, JAXBException;
}
