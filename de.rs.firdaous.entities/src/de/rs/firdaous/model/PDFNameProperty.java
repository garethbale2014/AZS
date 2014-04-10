package de.rs.firdaous.model;


public enum PDFNameProperty {
  
  // TODO alle diese Informationen in der Datenbank ablegen 00

	decederFirstNameLastName("Formular1[0].Seite1[0].#area[26].name1[0]Familienname, Vorname der/des Verstorbenen"),
	decederBirthDay("Geburtsdatum8388609"),
	decederBirthPlace("Geburtsort8392705"),
	decederAddresseStreetNrCityZip("Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)8392704"),
	
	constituantFirstNameLastName("Formular1[0].Seite1[0].#area[2].name2[0]Auftraggeberin/Auftraggeber Familienname, Vorname, ggf. Geburtsname"),
	constituantBirthDay("Formular1[0].Seite1[0].#area[20].geburtsdatum2[0]Geburtsdatum"),
	constituantBirthPlace("Formular1[0].Seite1[0].#area[21].geburtsort2[0]Geburtsort"),
	constituantAddresseStreetNrCityZip("Formular1[0].Seite1[0].#area[3].anschrift2[0]Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)"),
	constituantDatum("Formular1[0].Seite1[0].#area[8].datum1[0]Datum"),
	
	entrySupplierFirstLastName("Formular1[0].Seite1[0].#area[14].name5[0]Antragstellerin/Antragsteller Familienname, Vorname, ggf. Geburtsname"),
	entrySupplierBirthDay("Formular1[0].Seite1[0].#area[15].geburtsdatum5[0]Geburtsdatum"),
	entrySupplierBirthCity("Formular1[0].Seite1[0].#area[16].geburtsort5[0]"),
	entrySupplierAddresseStreetNrCityZip("Formular1[0].Seite1[0].#area[17].anschrift5[0]Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)"),
	
	
	otherDeceder01("Formular1[0].Seite1[0].#area[4].name3[0]Als weitere Bestattungspflichtige benenne ich: Familienname, Vorname, ggf. Geburtsname"),
	otherDeceder01BirthDay("Formular1[0].Seite1[0].#area[22].geburtsdatum3[0]Geburtsdatum"),
	otherDeceder01BirthPlace("Formular1[0].Seite1[0].#area[16].geburtsort5[0]Geburtsort"),
	otherDeceder01AddresseStreetNrCityZip("Formular1[0].Seite1[0].#area[5].anschrift3[0]Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)"),
	
	otherDeceder02("Formular1[0].Seite1[0].#area[6].name4[0]Als weitere Bestattungspflichtige benenne ich: Familienname, Vorname, ggf. Geburtsname"),
	otherDeceder02BirthDay("Formular1[0].Seite1[0].#area[23].geburtsdatum4[0]Geburtsdatum"),
	otherDeceder02BirthPlace("Formular1[0].Seite1[0].#area[25].geburtsort4[0]Geburtsort"),
	otherDeceder02AddresseStreetNrCityZip("Formular1[0].Seite1[0].#area[7].anschrift4[0]Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)"),
	
	morticianName("Formular1[0].Seite1[0].#area[0].bestatter[0]Stempel oder Eingabe von Name, Anschrift, Telefon- und Telefaxnummer des Bestattungsunternehmens"),
	morticianCreation("Geburtsdatum8388609"),
	morticianLeader("Geburtsort8392705"),
	morticianAddresseStreetNrCityZip("Formular1[0].Seite1[0].#area[3].anschrift2[0]Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)"),
	
	friedhofName("Formular1[0].Seite1[0].#area[28].friedhof1[0]Friedhof"),
	friedhofGrabNr("Formular1[0].Seite1[0].#area[10].#area[13].Grab[0]Grab"),
	friedhof("Formular1[0].Seite1[0].#area[10].#area[11].Friedhof[0]Friedhof"),
	friedhofGrabArt(""),
	friedhofFeld("Formular1[0].Seite1[0].#area[10].#area[12].Feld[0]Feld"),
	friedhofAddresseStreetNrCityZip("Wohnungsanschrift (Straße, Hausnummer, Postleitzahl, Ort)8392704"),
	
	projectCreationDate("Formular1[0].Seite1[0].#area[18].datum2[0]Datum"),	
	projectCosts("Formular1[0].Seite1[0].#area[27].Betrag14[0]Gesamtbetrag der städtischen Gebühren ... EUR"),
	
	saveButton("Formular1[0].Seite1[0].FS_aktbtn3[0]Speichern"),
	signButton("Formular1[0].Seite1[0].FS_aktbtn8[0]Signieren/Versenden"),
	//Formular1[0].Seite1[0].#area[6].verstorbener[0]Familienname, Vorname, ggf. Geburtsname der/des Verstorbenen
	balVerstorbenen("Formular1[0].Seite1[0].#area[6].verstorbener[0]Familienname, Vorname, ggf. Geburtsname der/des Verstorbenen"),
	balZellenbenutzung("Formular1[0].Seite2[0].#area[27].kreuz2b[0]Zellenbenutzung"),
	balErsatzurkunde("Formular1[0].Seite1[0].#area[52].kreuz15[0]Ersatzurkunde"),
	balreligion("Formular1[0].Seite3[0].#area[9].religion[0]Religionszugehörigkeit der/des Verstorbenen"),
	balnormal("Formular1[0].Seite1[0].#area[31].kreuz5[0]normal"),
	balueberfuehrungsdatum("Formular1[0].Seite3[0].#area[13].ueberfuehrungsdatum[0]Datum der Überführung"),
	baltagesauswahl("Formular1[0].Seite1[0].#area[14].tagesauswahl[0]Termin der Bestattung am ... (Wochentag)"),
	balbemerkungen("Formular1[0].Seite2[0].#area[19].#area[20].bemerkungen[0]Bemerkungen/Änderungen"),
	balTrauerfeier("Formular1[0].Seite2[0].#area[17].kreuz1a[0]mit Trauerfeier"),
	balJahre1("Formular1[0].Seite1[0].#area[39].kreuz9b[0]12 Jahre"),
	balBestattungsunternehmens("Formular1[0].Seite3[0].#area[0].bestatter[0]Name und Anschrift des Bestattungsunternehmens"),
	balGrab("Formular1[0].Seite3[0].#area[44].kreuz10a[0]vorhandenes Grab"),
	balGrabArt("Formular1[0].Seite1[0].#area[1].#area[4].grabart[0]Grabart"),
	balFeld("Formular1[0].Seite1[0].#area[1].#area[3].feld[0]"),	
	balGrabNr("Formular1[0].Seite1[0].#area[1].#area[5].grabnummer[0]"),
	balTieferlegung("Formular1[0].Seite1[0].#area[34].kreuz7[0]Tieferlegung"),
	balUrnenbeisetzung("Formular1[0].Seite3[0].#area[36].kreuz8a[0]Urnenbeisetzung"),
	balTerminDerBestattung("Formular1[0].Seite3[0].#area[14].tagesauswahl[0]Termin der Bestattung am ... (Wochentag)"),
	balJahre2("Formular1[0].Seite2[0].#area[35].text7[0]Jahre"),
	balMitTrauerfeier("Formular1[0].Seite1[0].#area[17].kreuz1a[0]mit Trauerfeier"),
	balErstazKunde("Formular1[0].Seite1[0].#area[52].kreuz15[0]Ersatzurkunde");
	
//	balverstorbener(""),
//	balverstorbener(""),
//	balverstorbener(""),
//	balverstorbener(""),
//	balverstorbener(""),
//	balverstorbener(""),;
	
	
	private String value;
	
	private FormPDFProperty pdfFieldName;
	
	public static PDFNameProperty getNameFromValue(String value){
	  System.out.println(value);
		if (value == null) {
            throw new IllegalArgumentException ("Parameter value " +
                    "cannot be null.");
        }
		for(PDFNameProperty pdfName : PDFNameProperty.values()){
		  //System.out.println(pdfName.value);
			if(value.equals(pdfName.value))
					return pdfName;
		}
		return null;
	}
	
	private PDFNameProperty(String value) {
		this.value = value;
		
	}
	
	public void setPdfFieldName(FormPDFProperty pdfFieldName) {
		this.pdfFieldName = pdfFieldName;
	}
	
	public FormPDFProperty getPdfFieldName() {
		return pdfFieldName;
	}
	public String getValue() {
		return value;
	}
}
