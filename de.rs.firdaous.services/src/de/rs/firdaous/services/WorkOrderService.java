package de.rs.firdaous.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;

import de.ralfebert.rcputils.random.RandomData;
import de.rs.firdaous.model.Address;
import de.rs.firdaous.model.Cemetery;
import de.rs.firdaous.model.Country;
import de.rs.firdaous.model.Genre;
import de.rs.firdaous.model.Mortician;
import de.rs.firdaous.model.Pair;
import de.rs.firdaous.model.PersonData;
import de.rs.firdaous.model.WorkOrder;

public class WorkOrderService implements IWorkOrderService {
  
  public static final Format formatShortDotDelimiter = new SimpleDateFormat("dd.MM.yy");
  
  private List<WorkOrder> orders;
  
  private Set<Country> countries ;
  
  private final LinkedHashSet<IAddressChangeListener> addressChangeListeners = new LinkedHashSet<IAddressChangeListener>();

  @Override
  public List<WorkOrder> getAllWorkOrder() {
   
    return orders;
  }
  
  public WorkOrderService() {
    orders = new ArrayList<WorkOrder>();
    countries = new HashSet<Country>();
   
    for (String countryName : RandomData.COUNTRIES) {
      countries.add(new Country(countryName));
    }
    
    WorkOrder order;
    for (int i = 1; i <= 450; i++) {
      RandomData rd = new RandomData(i);
      
      order = new WorkOrder();
      order.setCosts(rd.someCost());
      order.setProjectId(System.nanoTime());
      PersonData person = new PersonData();
      person.setFirstname(rd.someGivenName());
      person.setLastname(rd.someLastName());
      person.setBirthCity(rd.someCity());
      person.setBirthday(generateDOB());
      person.setDecedDay(generateDOB());
      Address address = new Address();
      address.setStreet(rd.someStreetWithoutNr());
      address.setHouseNumber(rd.someStreetNumber());
      address.setZip(rd.someZipCode());
      address.setCity(rd.someCity());
      address.setCountry(rd.someElement(countries));
      address.setEmail(rd.someEmail());
      person.setAddresse(address);      
      RandomData rd2 = new RandomData(i+450);      
      PersonData partner = new PersonData();
      partner.setFirstname(rd2.someGivenName());
      partner.setLastname(rd2.someLastName());
      partner.setBirthCity(rd2.someCity());
      partner.setBirthday(generateDOB());
      partner.setDecedDay(generateDOB());
      partner.setAddresse(address);
      int sexe = rd2.someGeschlect();
      partner.setSexe(Genre.values()[--sexe]);
      order.setPartner(partner);
      order.setPerson(person);
      Pair pair = new Pair(person, partner);
      //Auftraggeber(in)
      RandomData rd3 = new RandomData(i+45); 
      PersonData entrySupplier = new PersonData();
      entrySupplier.setFirstname(rd3.someGivenName());
      entrySupplier.setLastname(rd3.someLastName());
      entrySupplier.setBirthCity(rd3.someCity());
      entrySupplier.setBirthday(generateDOB());
      entrySupplier.setDecedDay(generateDOB());
      Address addressEntrySupplier = new Address();
      addressEntrySupplier.setStreet(rd3.someStreetWithoutNr());
      addressEntrySupplier.setHouseNumber(rd3.someStreetNumber());
      addressEntrySupplier.setZip(rd3.someZipCode());
      addressEntrySupplier.setCity(rd3.someCity());
      addressEntrySupplier.setCountry(rd3.someElement(countries));
      addressEntrySupplier.setEmail(rd3.someEmail());
      entrySupplier.setAddresse(addressEntrySupplier);     
      order.setEntrySupplier(entrySupplier);
      //furtherDecederFirst
      RandomData rd3FurtherDecederFirst = new RandomData(i+45); 
      PersonData furtherDecederFirst = new PersonData();
      furtherDecederFirst.setFirstname(rd3FurtherDecederFirst.someGivenName());
      furtherDecederFirst.setLastname(rd3FurtherDecederFirst.someLastName());
      furtherDecederFirst.setBirthCity(rd3FurtherDecederFirst.someCity());
      furtherDecederFirst.setBirthday(generateDOB());
      furtherDecederFirst.setDecedDay(generateDOB());
      Address addressFurtherDecederFirst = new Address();
      addressFurtherDecederFirst.setStreet(rd3FurtherDecederFirst.someStreetWithoutNr());
      addressFurtherDecederFirst.setHouseNumber(rd3FurtherDecederFirst.someStreetNumber());
      addressFurtherDecederFirst.setZip(rd3FurtherDecederFirst.someZipCode());
      addressFurtherDecederFirst.setCity(rd3FurtherDecederFirst.someCity());
      addressFurtherDecederFirst.setCountry(rd3FurtherDecederFirst.someElement(countries));
      addressFurtherDecederFirst.setEmail(rd3FurtherDecederFirst.someEmail());
      furtherDecederFirst.setAddresse(addressFurtherDecederFirst);     
      order.setFurtherDecederFirst(furtherDecederFirst);
      
      //furtherDecederSecond
      RandomData rd3FurtherDecederSecond = new RandomData(i+95); 
      PersonData furtherDecederSecond = new PersonData();
      furtherDecederSecond.setFirstname(rd3FurtherDecederSecond.someGivenName());
      furtherDecederSecond.setLastname(rd3FurtherDecederSecond.someLastName());
      furtherDecederSecond.setBirthCity(rd3FurtherDecederSecond.someCity());
      furtherDecederSecond.setBirthday(generateDOB());
      furtherDecederSecond.setDecedDay(generateDOB());
      Address addressFurtherDecederSecond = new Address();
      addressFurtherDecederSecond.setStreet(rd3FurtherDecederSecond.someStreetWithoutNr());
      addressFurtherDecederSecond.setHouseNumber(rd.someStreetNumber());
      addressFurtherDecederSecond.setZip(rd3FurtherDecederSecond.someZipCode());
      addressFurtherDecederSecond.setCity(rd3FurtherDecederSecond.someCity());
      addressFurtherDecederSecond.setCountry(rd3FurtherDecederSecond.someElement(countries));
      addressFurtherDecederSecond.setEmail(rd3FurtherDecederSecond.someEmail());
      furtherDecederSecond.setAddresse(addressFurtherDecederSecond);     
      order.setFurtherDecederSecond(furtherDecederSecond);
      
      
      
      //Constituent
      RandomData rd3Constituent = new RandomData(i+85); 
      PersonData constituent = new PersonData();
      constituent.setFirstname(rd3Constituent.someGivenName());
      constituent.setLastname(rd3Constituent.someLastName());
      constituent.setBirthCity(rd3Constituent.someCity());
      constituent.setBirthday(generateDOB());
      constituent.setDecedDay(generateDOB());
      Address addressConstituent = new Address();
      addressConstituent.setStreet(rd3Constituent.someStreetWithoutNr());
      addressConstituent.setHouseNumber(rd.someStreetNumber());
      addressConstituent.setZip(rd3Constituent.someZipCode());
      addressConstituent.setCity(rd3Constituent.someCity());
      addressConstituent.setCountry(rd3Constituent.someElement(countries));
      addressConstituent.setEmail(rd3Constituent.someEmail());
      constituent.setAddresse(addressConstituent);     
      order.setConstituent(constituent);
      //cemetery
      RandomData rd3Cemetery = new RandomData(i+55); 
      Cemetery cemetery = new Cemetery();
      cemetery.setName("Friedhof "+rd3Cemetery.someGivenName()+" "+rd3Cemetery.someCity());
      cemetery.setFeld(rd3Cemetery.someDigits(3));
      cemetery.setGrabNr(rd3Cemetery.someDigits(5));
      cemetery.setGrabArt(rd3.someDigits(6));
      //constituent.setDecedDay(generateDOB());
      Address addressCemetery = new Address();
      
      addressCemetery.setStreet(rd3Cemetery.someStreetWithoutNr());
      addressCemetery.setHouseNumber(rd.someStreetNumber());
      addressCemetery.setZip(rd3Cemetery.someZipCode());
      addressCemetery.setCity(rd3Cemetery.someCity());
      addressCemetery.setCountry(rd3Cemetery.someElement(countries));
      addressCemetery.setEmail(rd3Cemetery.someEmail());
      cemetery.setAddress(addressCemetery);     
      order.setCemetery(cemetery);
      //mortician
      RandomData rd3Mortician = new RandomData(i+65);
      Mortician mortician = new  Mortician();
      PersonData morticianLeader = new PersonData();
      morticianLeader.setFirstname(rd3Mortician.someGivenName());
      morticianLeader.setLastname(rd3Mortician.someLastName());
      morticianLeader.setBirthCity(rd3Mortician.someCity());
      morticianLeader.setBirthday(generateDOB());
      morticianLeader.setDecedDay(generateDOB());
      mortician.setLeader(morticianLeader);
      mortician.setName(rd3Mortician.somePersonName());
      Address addressMortician = new Address();
      addressMortician.setStreet(rd3Mortician.someStreetWithoutNr());
      addressMortician.setHouseNumber(rd.someStreetNumber());
      addressMortician.setZip(rd3Mortician.someZipCode());
      addressMortician.setCity(rd3Mortician.someCity());
      addressMortician.setCountry(rd3Mortician.someElement(countries));
      addressMortician.setEmail(rd3Mortician.someEmail());
      mortician.setAddresse(addressMortician);     
      order.setMortician(mortician);
      
      order.setPair(pair);
      
      
      
      
      
      order.setWorkOrderDate(new Date(Math.abs(RandomUtils.nextLong() - RandomUtils.nextLong())));
      Date dob = generateDOB();
      order.setWorkOrderDate(dob);
      orders.add(order);
    }
  }
  
  public List<WorkOrder> getOrders() {
    return orders;
  }

  @Override
  public void addAddressChangeListener(IAddressChangeListener addressChangeListener) {
    this.addressChangeListeners.add(addressChangeListener);
    
  }

  @Override
  public void removeAddressChangeListener(IAddressChangeListener listener) {
    // TODO Auto-generated method stub
    
  }
  
  
  private static long ONE_YEAR_AS_MILLISECONDS = 365*24*60*60*1000;
  private static long TWENTY_FIVE_YEARS_AS_MILLISECONDS = 25*ONE_YEAR_AS_MILLISECONDS;
  private static long FIFTY_YEARS_AS_MILLISECONDS = 50*ONE_YEAR_AS_MILLISECONDS;

  private static Date generateDOB()
  {
      //Equation for calculating a random number within a given range is as follows:  Min + (int)(Math.random() * ((Max - Min) + 1))
      long someTimeBetween25And50YearsInMilliSeconds = TWENTY_FIVE_YEARS_AS_MILLISECONDS + 
                  (long)(Math.random() * ((FIFTY_YEARS_AS_MILLISECONDS - TWENTY_FIVE_YEARS_AS_MILLISECONDS) + 1));
      Calendar dob = Calendar.getInstance();
      dob.setTimeInMillis(dob.getTimeInMillis() - someTimeBetween25And50YearsInMilliSeconds);
      return dob.getTime();
//      StringBuffer sb = new StringBuffer();
//      sb.append(dob.get(Calendar.YEAR)).append("/").append(dob.get(Calendar.MONTH)+1).append("/").append(dob.get(Calendar.DAY_OF_MONTH));
//      return sb.toString();
  }

  @Override
  public void deleteWorkOrder(Long projectId) {
    for (Iterator<WorkOrder> i = orders.iterator(); i.hasNext();) {
      WorkOrder order = i.next();
      if (order.getProjectId() == projectId) {
        i.remove();
        //fireAddressChange();
        return;
      }
    }
    
  }
  

}
