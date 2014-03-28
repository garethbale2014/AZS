package com.theopentutorials.jaxb.to;
 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
 
@XmlType
public class Address {
	
	 @XmlAttribute
    private String street;
    private String city;
    private String state;
    private long zip;
    
    public Address() {
		// TODO Auto-generated constructor stub
	}
    
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public long getZip() {
        return zip;
    }
    public void setZip(long zip) {
        this.zip = zip;
    }
    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", state="
                + state + ", zip=" + zip + "]";
    }
}