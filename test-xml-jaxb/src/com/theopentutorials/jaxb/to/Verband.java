package com.theopentutorials.jaxb.to;

public class Verband {
	
	private String name;
	private String manager;
	
	public Verband() {
		
	}

	public Verband(String name, String manager) {
		super();
		this.name = name;
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	
	

}
