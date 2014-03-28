package com.theopentutorials.jaxb.xml;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.theopentutorials.jaxb.to.Employee;
 
public class JAXBXMLHandler {
 
    // Export: Marshalling
    public static void marshal(Employee employee, File selectedFile)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(Employee.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(employee, writer);
        writer.close();
    }
 
    // Import: Unmarshalling
    public static Employee unmarshal(File importFile) throws JAXBException {
        Employee employee = null;
        JAXBContext context;
 
        context = JAXBContext.newInstance(Employee.class);
        Unmarshaller um = context.createUnmarshaller();
        employee = (Employee) um.unmarshal(importFile);
 
        return employee;
    }
}