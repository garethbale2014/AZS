package de.rs.firdaous.model;

import java.util.Date;

public class Mortician {
  
  private long morticianId;
  
  private String name;
  
  private Address addresse;
  
  private PersonData leader;
  
  private Date creationDate;
  
  public Mortician() {
    
  }
  
  

  public Mortician(String name, Address addresse, PersonData leader, Date creationDate) {
    super();
    this.name = name;
    this.addresse = addresse;
    this.leader = leader;
    this.creationDate = creationDate;
  }



  public long getMorticianId() {
    return morticianId;
  }

  public void setMorticianId(long morticianId) {
    this.morticianId = morticianId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddresse() {
    return addresse;
  }

  public void setAddresse(Address addresse) {
    this.addresse = addresse;
  }

  public PersonData getLeader() {
    return leader;
  }

  public void setLeader(PersonData leader) {
    this.leader = leader;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
  
  

}
