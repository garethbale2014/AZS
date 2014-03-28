package de.rs.xml.test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields.Item;

import de.rs.firdaous.xml.service.IDocumentService;
import de.rs.firdaous.xml.service.IXMLService;
import de.rs.firdaous.xml.service.ProjectList;
import de.rs.firdaous.xml.service.ServiceForDocument;
import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.Address;
import de.rs.prototype.firdaous.model.Cemetery;
import de.rs.prototype.firdaous.model.Clinic;
import de.rs.prototype.firdaous.model.Country;
import de.rs.prototype.firdaous.model.FamillyState;
import de.rs.prototype.firdaous.model.FieldInfoList;
import de.rs.prototype.firdaous.model.Mortician;
import de.rs.prototype.firdaous.model.PersonData;
import de.rs.prototype.firdaous.model.PhoneNumber;
import de.rs.prototype.firdaous.model.Police;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.prototype.utils.DateUtils;
import de.rs.prototype.utils.FieldUtils;

public class TestXMLService {

  private IXMLService xmlService = XMLService.getxmlService();
  
  static WorkOrder workOrder;

  public static String ANLAGE = "./resources/AZSUnlocked.pdf";

  @Before
  public void setUp() {

    createTestData();

  }

  @Ignore
  @Test
  public void encryptPDF() {
    IDocumentService instance = ServiceForDocument.getInstance();
    try {
      instance.encryptPdf(null, null);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  @Ignore
  @Test
  public void copyPDF() {
    IDocumentService instance = ServiceForDocument.getInstance();
    try {
      instance.copyPDF(null);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
  
  @Ignore
  @Test
  public void setFieldInfo_TO_PDF() throws IOException, ParserConfigurationException, SAXException,
          DocumentException {
    IDocumentService instance = ServiceForDocument.getInstance();
    Map<String, Item> map = instance.getPDFFieldMap(ANLAGE);
    FieldInfoList fieldInfoList = FieldUtils.initializeFieldList(workOrder, map);
    instance.setFieldToPDF(fieldInfoList);
  }

  @Ignore
  @Test
  public void setField_ShowFieldValue() {
    IDocumentService instance = ServiceForDocument.getInstance();
    try {
      instance.setFieldToPDF(workOrder, null);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }

  }

 
  @Test
  public void testSaveProjectList() throws IOException {
    xmlService.saveProjects(workOrder);
//    xmlService.saveProjects(workOrder);
//    xmlService.saveProjects(workOrder);
//    xmlService.saveProjects(workOrder);
  }

  @Ignore
  @Test
  public void setLoadProjectList() throws IOException {
    try {
      ProjectList list = xmlService.loadProjectList();
      System.out.println();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void createTestData() {

    Calendar calendarBirthDay = Calendar.getInstance();
    calendarBirthDay.set(Calendar.YEAR, 1945);
    calendarBirthDay.set(Calendar.MONTH, 5);
    calendarBirthDay.set(Calendar.DAY_OF_MONTH, 14);
    Calendar calendarDieDay = Calendar.getInstance();
    calendarDieDay.set(Calendar.YEAR, 1990);
    calendarDieDay.set(Calendar.MONTH, 3);
    calendarDieDay.set(Calendar.DAY_OF_MONTH, 24);

    workOrder = new WorkOrder();
    Calendar entryDate = Calendar.getInstance();
    entryDate.getTime().setTime(System.currentTimeMillis());
    workOrder.setWorkOrderDate(entryDate.getTime());
    PersonData personData = workOrder.getPerson();
    personData.setFirstname("Albert");
    personData.setLastname("Einstein");
    personData.setBirthCity("Koblenz");
    personData.setBirthday(calendarBirthDay.getTime());
    personData.setDecedDay(calendarDieDay.getTime());
    PersonData personDataPartner = new PersonData();
    personDataPartner.setLastname("Aniett");
    personDataPartner.setFirstname("Lorf");

    workOrder.setPartner(personDataPartner);
    Address addresse = new Address();
    addresse.setCity("Virginia");
    Country country = new Country();
    country.setName("USA");
    addresse.setCountry(country);
    addresse.setStreet("marguerittestr");
    addresse.setHouseNumber("112a");
    addresse.setZip("551487");
    personData.setProfession("Physiker");
    personData.setAddresse(addresse);
    personDataPartner.setAddresse(addresse);
    PhoneNumber phone = new PhoneNumber(0034, 34, 66544);
    personData.setPhone(phone);
    personDataPartner.setPhone(phone);
    FamillyState famillyState = FamillyState.verheiratet;
    personData.setFamillyState(famillyState);
    personDataPartner.setFamillyState(famillyState);
    Clinic clinic = new Clinic();
    clinic.setName("Hospital Bale");
    addresse.setStreet("Havinggulstr");
    clinic.setAddress(addresse);
    Police police = new Police();
    addresse.setStreet("heighway");
    police.setName("Police newyork city");
    police.setAddress(addresse);
    workOrder.setPerson(personData);
    workOrder.setPolice(police);
    workOrder.setClinic(clinic);
    long id = System.currentTimeMillis();
    workOrder.setProjectId(id);
    workOrder.setUserName(System.getenv("USERNAME"));
    
    Cemetery cemetery = new Cemetery("cemetryDummyValue", "FeldAngaben??", "GrabArt", "2387A7");
    Address addressCemetery = new Address();
    addressCemetery.setCity("München");
    addressCemetery.setStreet("salzburgerstr");
    addressCemetery.setHouseNumber("109");
    addressCemetery.setZip("98999");
    cemetery.setAddress(addressCemetery);
    workOrder.setCemetery(cemetery);
    
    Address addressMortician = new Address();
    addressMortician.setCity("Krefeld");
    addressMortician.setStreet("Uerdingerstr");
    addressMortician.setHouseNumber("222B");
    addressMortician.setZip("41457");
    PersonData constituant = new PersonData();
    constituant.setFirstname("Charlotte");
    constituant.setLastname("Kopers");
    constituant.setBirthCity(RandomStringUtils.randomAlphabetic(13).toLowerCase());
    constituant.setBirthday(DateUtils.createBrithDayRandomly());
    Address addressconstituant = new Address();
    addressconstituant.setCity("Köln");
    addressconstituant.setStreet("Domweg");
    addressconstituant.setHouseNumber("80 a");
    addressconstituant.setZip("50457");
    constituant.setAddresse(addressconstituant);
    workOrder.setConstituent(constituant);
    
    PersonData morticianLeader = new PersonData();
    morticianLeader.setFirstname("WNIYA");
    morticianLeader.setLastname("HUBBY");
    Calendar calendar = Calendar.getInstance();
    Mortician mortician = new Mortician("Firdaous Bestatter", addressMortician, morticianLeader, calendar.getTime() );
    
    PersonData furtherDecederFirst = new PersonData();
    furtherDecederFirst.setBirthCity("furtherDecederFirstHamburg");
    Address addressDecederFirst = new Address();
    addressDecederFirst.setCity("Köln");
    addressDecederFirst.setStreet("Erfurterstr");
    addressDecederFirst.setHouseNumber("5b");
    addressDecederFirst.setZip("32554");
    furtherDecederFirst.setAddresse(addressDecederFirst);
    furtherDecederFirst.setDecedDay(DateUtils.createBrithDayRandomly());
    furtherDecederFirst.setBirthday(DateUtils.createBrithDayRandomly());
    furtherDecederFirst.setFirstname(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    furtherDecederFirst.setLastname(RandomStringUtils.randomAlphabetic(7).toLowerCase());
    
    PersonData furtherDecederSecond = new PersonData();
    furtherDecederSecond.setBirthCity(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    Address addressDecederSecond = new Address();
    addressDecederSecond.setCity("furtherDecederSecondDresden");
    addressDecederSecond.setStreet(RandomStringUtils.randomAlphabetic(13).toLowerCase());
    addressDecederSecond.setHouseNumber(RandomStringUtils.randomAlphanumeric(2).toLowerCase());
    addressDecederSecond.setZip("32554");    
    furtherDecederSecond.setAddresse(addressDecederSecond);
    furtherDecederSecond.setDecedDay(DateUtils.createBrithDayRandomly());
    furtherDecederSecond.setBirthday(DateUtils.createBrithDayRandomly());
    furtherDecederSecond.setFirstname(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    furtherDecederSecond.setLastname(RandomStringUtils.randomAlphabetic(7).toLowerCase());
    workOrder.setFurtherDecederFirst(furtherDecederFirst);
    workOrder.setFurtherDecederSecond(furtherDecederSecond);
    workOrder.setMortician(mortician);
    workOrder.setCosts(300);
    workOrder.setProjectId(System.currentTimeMillis());
    
    PersonData entrySupplier = new PersonData();
    entrySupplier.setBirthCity(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    Address addressEntrySupplier = new Address();
    addressEntrySupplier.setCity("EntySupplier city");
    addressEntrySupplier.setStreet(RandomStringUtils.randomAlphabetic(13).toLowerCase());
    addressEntrySupplier.setHouseNumber(RandomStringUtils.randomAlphanumeric(2).toLowerCase());
    addressEntrySupplier.setZip("88774");    
    entrySupplier.setAddresse(addressEntrySupplier);
    entrySupplier.setDecedDay(DateUtils.createBrithDayRandomly());
    entrySupplier.setBirthday(DateUtils.createBrithDayRandomly());
    entrySupplier.setFirstname(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    entrySupplier.setLastname(RandomStringUtils.randomAlphabetic(7).toLowerCase());
    workOrder.setEntrySupplier(entrySupplier);
  }
  
  
  
}
