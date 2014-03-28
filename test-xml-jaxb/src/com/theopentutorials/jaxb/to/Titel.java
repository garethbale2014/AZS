package com.theopentutorials.jaxb.to;



public class Titel {
	
	
	private String titleName;
	private int titelCounter;
	private Verband verband;
	
	public Titel() {
		// TODO Auto-generated constructor stub
	}

	public Titel(String titleName, int titelCounter, Verband verband) {
		super();
		this.titleName = titleName;
		this.titelCounter = titelCounter;
		this.verband = verband;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public int getTitelCounter() {
		return titelCounter;
	}

	public void setTitelCounter(int titelCounter) {
		this.titelCounter = titelCounter;
	}
	
	public Verband getVerband() {
		return verband;
	}
	public void setVerband(Verband verband) {
		this.verband = verband;
	}
	
	

}
