package de.rs.utils;

import java.util.Date;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfObject;

import de.rs.auxiliary.FormatUtil;
import de.rs.firdaous.model.FieldInfo;
import de.rs.firdaous.model.FieldInfoList;
import de.rs.firdaous.model.FormPDFProperty;
import de.rs.firdaous.model.PDFNameProperty;
import de.rs.firdaous.model.WorkOrder;


public final class FieldUtils {

  public static FieldInfoList initializeFieldList(WorkOrder order, Map<String, AcroFields.Item> map) {
    FieldInfoList fieldInfoList = new FieldInfoList();
    String pdfName = "";
    String dateStr = "";
    Object value = "";
    for (Entry<String, AcroFields.Item> entry : map.entrySet()) {

      String itemName = entry.getKey();
      AcroFields.Item item = entry.getValue();
      List<PdfDictionary> d = item.values;

      int i = 0;
      Set<PdfName> keys;
      StringBuilder pdfNameStr = new StringBuilder();
      pdfNameStr.append(itemName);

      
      if (itemName.startsWith("Formular1[0].Seite1")) {
        System.out.println(itemName);
        for (PdfDictionary pdfDictionary : d) {
          keys = pdfDictionary.getKeys();
          for (PdfName k : keys) {
            PdfObject pdfObject = pdfDictionary.get(k);
            String s = pdfObject.toString().trim();
            if (i == 0) 
              pdfNameStr.append(s);
            System.out.println(pdfObject);
            i++;

          }

          System.out.println("Eindeutige bezeichner : [" + pdfNameStr + "]");
          System.out.println("/////////////////////////////////////////////////////////////");
          pdfNameStr = new StringBuilder(pdfNameStr.toString().replaceAll("\n", ""));
          String s = pdfNameStr.toString().replaceAll(RSConstant.notPrintableCharacter, "");
          pdfNameStr = new StringBuilder(s);
          PDFNameProperty pdfNameTmp = PDFNameProperty.getNameFromValue(pdfNameStr.toString());
          if (pdfNameTmp != null) {
            FormPDFProperty pdfProperty = FormPDFProperty.getPropertyName(itemName);
            pdfNameTmp.setPdfFieldName(pdfProperty);
            switch (pdfNameTmp) {
              case decederAddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object decederAddresseStreetNrCityZip = order.getPerson().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, decederAddresseStreetNrCityZip));
                break;
              case decederBirthDay:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object decederBirthDay = order.getPerson().getBirthday();
                dateStr = FormatUtil.toDateString(decederBirthDay, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, dateStr));
                break;
              case decederBirthPlace:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object decederBirthPlace = order.getPerson().getBirthCity();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, decederBirthPlace));

                break;
              case decederFirstNameLastName:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object firstname = order.getPerson().getFirstname();
                Object lastName = order.getPerson().getLastname();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, String
                        .format("%s, %s", firstname, lastName)));
                break;
              case constituantAddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object address = order.getConstituent().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, address));
                break;
              case constituantBirthDay:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object date = order.getConstituent().getBirthday();
                dateStr = FormatUtil.toDateString(date, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, dateStr));
                break;
              case constituantBirthPlace:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                Object place = order.getConstituent().getBirthCity().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, place));
                break;
              case constituantFirstNameLastName:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                
                value = String.format("%s, %s", order.getConstituent().getFirstname(), order.getConstituent()
                        .getLastname());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
                
              case friedhofAddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getAddress().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case friedhofGrabArt:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getGrabArt();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case friedhofGrabNr:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getGrabNr();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case friedhofName:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getName();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case friedhof:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getName();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
                
              case friedhofFeld:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getFeld();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case morticianAddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = String.format("%s \n, %s", order.getMortician().getName(), order.getMortician()
                        .getAddresse().toString());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case morticianCreation:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getMortician().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case morticianLeader:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = String.format("%s, %s", order.getMortician().getLeader().getFirstname(), order
                        .getMortician().getLeader().getLastname());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case morticianName:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getMortician().getAddresse().toString();
                value = String.format("%s \n %s", order.getMortician().getName(), order.getMortician()
                        .getAddresse().toString());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case projectCosts:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCosts();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case projectCreationDate:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = new Date(order.getProjectId());
                value = FormatUtil.toDateString(value, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder01:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = String.format("%s, %s", order.getFurtherDecederFirst().getFirstname(), order.getFurtherDecederFirst().getLastname());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder01AddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getFurtherDecederFirst().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder01BirthDay:
                value = order.getFurtherDecederFirst().getBirthday();
                value = FormatUtil.toDateString(value, FormatUtil.formatShortDotDelimiter);
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder01BirthPlace:
                value = order.getFurtherDecederFirst().getBirthCity();
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder02:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = String.format("%s, %s", order.getFurtherDecederSecond().getFirstname(), order.getFurtherDecederSecond().getLastname());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder02AddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getFurtherDecederSecond().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder02BirthDay:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getFurtherDecederSecond().getBirthday();
                value = FormatUtil.toDateString(value, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case otherDeceder02BirthPlace:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getFurtherDecederSecond().getBirthCity();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case constituantDatum:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = new Date(order.getProjectId());
                value = FormatUtil.toDateString(value, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case entrySupplierAddresseStreetNrCityZip:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getEntrySupplier().getAddresse().toString();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case entrySupplierBirthCity:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getEntrySupplier().getBirthCity();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case entrySupplierBirthDay:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getEntrySupplier().getBirthday();
                value = FormatUtil.toDateString(value, FormatUtil.formatShortDotDelimiter);
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case entrySupplierFirstLastName:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = String.format("%s, %s", order.getEntrySupplier().getFirstname(), order.getEntrySupplier().getLastname());
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;                
              case saveButton:
              case signButton:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, ""));
                break;
              case balVerstorbenen:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, String
                        .format("%s, %s", order.getPerson().getFirstname(), order.getPerson().getLastname())));
              case balBestattungsunternehmens:
                break;
              case balErsatzurkunde:
                break;
              case balGrab:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getGrabNr();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case balJahre1:
                break;
              case balJahre2:
                break;
              case balMitTrauerfeier:
                break;
              case balTerminDerBestattung:
                break;
              case balTieferlegung:
                break;
              case balTrauerfeier:
                break;
              case balUrnenbeisetzung:
                break;
              case balZellenbenutzung:
                break;
              case balbemerkungen:
                break;
              case balnormal:
                break;
              case balreligion:
                break;
              case baltagesauswahl:
                break;
              case balueberfuehrungsdatum:
                break;
              case balGrabArt:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getGrabArt();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case balFeld:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getFeld();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
              case balGrabNr:
                pdfName = pdfNameTmp.getPdfFieldName().getValue();
                value = order.getCemetery().getGrabNr();
                fieldInfoList.add(new FieldInfo(pdfName, pdfName, value));
                break;
                
              
              
                
            }
          }
        }
      }

    }
    return fieldInfoList;
  }
}
