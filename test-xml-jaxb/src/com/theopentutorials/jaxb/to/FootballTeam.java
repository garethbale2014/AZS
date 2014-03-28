package com.theopentutorials.jaxb.to;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



public class FootballTeam {
	
	private String name;
	private String city;
	private String trainerName;
	
	private List<Titel> titels;
	
	
	public FootballTeam() {
		
	}
	


	public FootballTeam(String name, String city, String trainerName, List<Titel> titels) {
		super();
		this.name = name;
		this.city = city;
		this.trainerName = trainerName;
		this.titels = titels;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
public List<Titel> getTitels() {
	return titels;
}
public void setTitels(List<Titel> titels) {
	this.titels = titels;
}
	
	
	 @Override
	    public String toString() {
	        return "Football team [ name=" + name + ", city="
	                + city + ", trainer=" + trainerName + "]";
	    }
	

}
