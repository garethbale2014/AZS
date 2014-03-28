package de.rs.prototype.firdaous.model;

public class Cemetery {
  
//  Friedhof
//  Feld
//  Grabart
//  Grab-Nr. (von – bis)
  private long cemetryId;
  
  private String name;
  
  private String feld;
  
  private String grabArt;
  
  private String grabNr;
  
  private Address address = new Address();

  public Cemetery() {
    
  }
  
  public Cemetery(String name, String feld, String grabArt, String grabNr) {
    this.name = name;
    this.feld = feld;
    this.grabArt = grabArt;
    this.grabNr = grabNr;
  }
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFeld() {
    return feld;
  }

  public void setFeld(String feld) {
    this.feld = feld;
  }

  public String getGrabArt() {
    return grabArt;
  }

  public void setGrabArt(String grabArt) {
    this.grabArt = grabArt;
  }

  public String getGrabNr() {
    return grabNr;
  }

  public void setGrabNr(String grabNr) {
    this.grabNr = grabNr;
  }
  
  public long getCemetryId() {
    return cemetryId;
  }
  
  public Address getAddress() {
    return address;
  }
  
  public void setAddress(Address address) {
    this.address = address;
  }
  
  

}
