package de.rs.firdaous.services;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.AcroFields.Item;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import de.rs.auxiliary.FormatUtil;
import de.rs.auxiliary.FormularName;
import de.rs.auxiliary.PdfReaderUtils;
import de.rs.firdaous.model.FieldInfoList;
import de.rs.firdaous.model.IPDFFieldInfo;
import de.rs.firdaous.model.WorkOrder;
import de.rs.utils.FieldUtils;


public class DocumentService implements IDocumentService {

  public  static IDocumentService instance;

  public static final String RESULT = "AZS_%s.pdf";
  
  public static final String BAL = "BAL_%s.pdf";

  private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public DocumentService() {

  }

  public  static IDocumentService getInstance() {
    if (instance == null) instance = new DocumentService();
    return instance;
  }

  @Override
  public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException,
          SAXException, DocumentException {

    // IPath relativePagePath = new
    // Path("./resources/AnlageZumSterbefall.pdf");
    // File fileIO = relativePagePath.toFile();
    InputStream input = DocumentService.class.getClassLoader().getResourceAsStream(file);
    PdfReader reader = new PdfReader(input);
    // copyPDF(fileIO.getAbsolutePath());
    String s = FormatUtil.toDateString(Calendar.getInstance().getTime(), format);
    String result = FormularName.getResultFileName(file);
    String newFile = String.format(result, s);
    newFile = newFile.replace("-", "_");
    newFile = newFile.replace(" ", "_");
    newFile = newFile.replace(":", "_");

    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(System.getProperty("user.home") + "/" + newFile));

    AcroFields acroFields = stamper.getAcroFields();

    @SuppressWarnings("unchecked")
    Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) stamper.getAcroFields().getFields();
    ArrayList<String> pdfItemsNames = new ArrayList<String>();
    Map<String, String> fieldValue = new HashMap<String, String>();
    for (int i = 0; i < map.size(); i++) {
      String itemName = (String) map.keySet().toArray()[i];
      pdfItemsNames.add(itemName);
      fieldValue.put(itemName, "");
    }
    
    FieldInfoList fieldInfoList = FieldUtils.initializeFieldList(order, map);
    
    
    
    
try {
      
      for (IPDFFieldInfo field : fieldInfoList) {
        
        if (field != null) {

          acroFields.setFieldProperty(field.getPdfName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
          acroFields.setField(field.getPdfName(), String.valueOf(field.getFieldValue()));
        }
      }

    } catch (DocumentException e) {
      e.printStackTrace();
    }

    stamper.close();
    reader.close();

  }

  @Override
  public void copyPDF(String file) throws IOException, DocumentException {
    IPath relativePagePath = new Path("./resources/AZSUnlocked.pdf");
    File fileIO = relativePagePath.toFile();
    PdfReader reader = new PdfReader(fileIO.getAbsolutePath());
    reader = unlockPdf(reader);
    Document document;
    PdfCopy copy;
    // loop over all the pages in the original PDF
    int n = reader.getNumberOfPages();
    for (int i = 0; i < n;) {
      // step 1
      document = new Document();
      // step 2
      copy = new PdfCopy(document, new FileOutputStream(String.format(RESULT, ++i)));
      // step 3
      document.open();
      // step 4
      copy.addPage(copy.getImportedPage(reader, i));
      // step 5
      document.close();
    }

    reader.close();

  }

  public static PdfReader unlockPdf(PdfReader reader) {
    if (reader == null) {
      return reader;
    }
    try {
      Field f = reader.getClass().getDeclaredField("encrypted");
      f.setAccessible(true);
      f.set(reader, false);
    } catch (Exception e) { // ignore
    }
    return reader;
  }

  @Override
  public void encryptPdf(String src, String dest) throws IOException, DocumentException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFieldToPDF(FieldInfoList fieldInfoList) throws IOException, ParserConfigurationException,
          SAXException, DocumentException {
    IPDFFieldInfo fieldDecederName = null;
    for(IPDFFieldInfo i : fieldInfoList){
      if(i.getPdfName().equals("Formular1[0].Seite1[0].#area[26].name1[0]"))
        fieldDecederName = i;
    }
    PdfReader reader = new PdfReader("./resources/AZSUnlocked.pdf");
    String s = FormatUtil.toDateString(Calendar.getInstance().getTime(), format);
    
    String newFile = String.format(RESULT, s, fieldDecederName.getFieldObjectValue());
    newFile = newFile.replace("-", "_");
    newFile = newFile.replace(" ", "_");
    newFile = newFile.replace(":", "_");
    newFile = newFile.replace(",", " ");
    FileOutputStream outputFile = new FileOutputStream(System.getProperty("user.home") + "/" + newFile);
    PdfStamper stamper = new PdfStamper(reader, outputFile);
    AcroFields acroFields = stamper.getAcroFields();
//    @SuppressWarnings("unchecked")
//    Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) stamper.getAcroFields().getFields();


    try {
      
      for (IPDFFieldInfo field : fieldInfoList) {
        
        if (field != null) {

          acroFields.setFieldProperty(field.getPdfName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
          acroFields.setField(field.getPdfName(), String.valueOf(field.getFieldValue()));
        }
      }

    } catch (DocumentException e) {
      e.printStackTrace();
    }

    stamper.close();
    reader.close();

  }

  @Override
  public Map<String, Item> getPDFFieldMap(String file) throws IOException, ParserConfigurationException,
          SAXException, DocumentException {
    PdfReader reader = new PdfReader(file);
    @SuppressWarnings("unchecked")
    Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) reader.getAcroFields().getFields();
    return map;
  }

  @Override
  public void setFieldToPDF(WorkOrder order) throws IOException, ParserConfigurationException, SAXException,
          DocumentException {
    IPDFFieldInfo fieldDecederName = null;
    InputStream input = DocumentService.class.getClassLoader().getResourceAsStream("resources/AZSUnlocked.pdf");
    PdfReader reader = new PdfReader(input);
    Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) reader.getAcroFields().getFields();
    FieldInfoList fieldInfoList = FieldUtils.initializeFieldList(order, map);
    for(IPDFFieldInfo i : fieldInfoList){
      if(i.getPdfName().equals("Formular1[0].Seite1[0].#area[26].name1[0]"))
        fieldDecederName = i;
    }
    
    String s = FormatUtil.toDateString(Calendar.getInstance().getTime(), format);
    
    String newFile = String.format(RESULT, s, fieldDecederName.getFieldObjectValue());
    newFile = newFile.replace("-", "_");
    newFile = newFile.replace(" ", "_");
    newFile = newFile.replace(":", "_");
    newFile = newFile.replace(",", " ");
    FileOutputStream outputFile = new FileOutputStream(System.getProperty("user.home") + "/" + newFile);
    PdfStamper stamper = new PdfStamper(reader, outputFile);
    AcroFields acroFields = stamper.getAcroFields();
//    @SuppressWarnings("unchecked")
//    Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) stamper.getAcroFields().getFields();


    try {
      
      for (IPDFFieldInfo field : fieldInfoList) {
        
        if (field != null) {

          acroFields.setFieldProperty(field.getPdfName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
          acroFields.setField(field.getPdfName(), String.valueOf(field.getFieldValue()));
        }
      }

    } catch (DocumentException e) {
      e.printStackTrace();
    }

    stamper.close();
    reader.close();
    
  }

}
