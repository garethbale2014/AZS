package com.theopentutorials.jaxb.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.theopentutorials.jaxb.to.Address;
import com.theopentutorials.jaxb.to.Company;
import com.theopentutorials.jaxb.to.Employee;
import com.theopentutorials.jaxb.to.FootballTeam;
import com.theopentutorials.jaxb.to.FootballTeamList;
import com.theopentutorials.jaxb.to.Titel;
import com.theopentutorials.jaxb.to.Verband;
import com.theopentutorials.jaxb.xml.JAXBXMLHandler;

public class JAXBDemo {
	public static void main(String[] args) {

		boolean onlyTeam = true;
		if (onlyTeam) {
			testeFootballTeam();
		} else {
			Address address = new Address();
			address.setStreet("2163, 1st Avenue");
			address.setCity("Peoria");
			address.setState("Illinois");
			address.setZip(61606);
			Employee employee = new Employee(1, "Kumar", "Development", address);
			Company company = new Company();
			company.setAddress(address);
			company.setEmployee(employee);
			try {
				// Marshalling: Writing Java object to XML file
				JAXBXMLHandler.marshal(employee, new File("employee.xml"));
				// Unmarshalling: Converting XML content to Java objects
				Employee employee2 = JAXBXMLHandler.unmarshal(new File("employee.xml"));
				System.out.println(employee2);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}

	private static void testeFootballTeam() {
		
		FootballTeamList list = new FootballTeamList();
		
		Verband verband = new Verband("DFB", "Uli Hoeness");
		Titel titelCls = new Titel("CL", 10, verband);
		
		Titel titelChampions = new Titel("Champions", 32, verband);
		
		List<Titel> titels = new ArrayList<Titel>();
		titels.add(titelChampions);
		titels.add(titelCls);
		FootballTeam team = new FootballTeam("Real Madrid", "Madrid", "Carlo Anchelloti", titels);
		list.addElement(team);
		try {
			JAXBContext context;
			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(new File("team.xml")));
			context = JAXBContext.newInstance(FootballTeamList.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(list, writer);
			writer.close();
			FootballTeamList team2;
			context = JAXBContext.newInstance(FootballTeamList.class);
			Unmarshaller um = context.createUnmarshaller();
			team2 = (FootballTeamList) um.unmarshal(new File("team.xml"));
			System.out.println(team2);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}