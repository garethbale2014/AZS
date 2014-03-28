package com.theopentutorials.jaxb.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FootballteamList")
public class FootballTeamList {
	
	private List<FootballTeam> list = new ArrayList<FootballTeam>();
	
	public FootballTeamList() {
		
	}
	
	public List<FootballTeam> getList() {
		return list;
	}
	
	public void setList(List<FootballTeam> list) {
		this.list = list;
	}
	
	public void addElement(FootballTeam footballTeam){
		this.list.add(footballTeam);
	}
	

}
