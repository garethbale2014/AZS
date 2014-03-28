package de.rs.pdf.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ServiceForDocument implements IDocumentServiceTest {

	public static IDocumentServiceTest instance;
	
	 public static final String RESULT= "./resources/sterbe_p%d.pdf";
	 
	 private static String USER_STR_BESTATTER_AUF = "28de068ad96beee2e69c1cafa51ba56f00000000000000000000000000000000";
	 private static String OWNER_STR_BESTATTER_AUF = "e812ba0a29d10479a5b321423e4f8fa0a682a46c7f2308873820a30af34832a5";
	 
	 
	 public static final  byte[] USER = USER_STR_BESTATTER_AUF.getBytes();
	    /** Owner password. */
	    public static final byte[] OWNER = OWNER_STR_BESTATTER_AUF.getBytes();
	 

	private ServiceForDocument() {

	}

	public static IDocumentServiceTest getInstance() {
		if (instance == null)
			instance = new ServiceForDocument();
		return instance;
	}
	
	@Override
	public void encryptPdf(String src, String dest) throws IOException, DocumentException {
		
		
		PdfReader reader = new PdfReader("./resources/UnlockedComBurg.pdf");
	        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("./resources/comburg_decrypted.pdf"));
        
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
		try {
			for (Entry<String, String> e : fieldValue.entrySet()) {
				acroFields.setFieldProperty(e.getKey(), "fflags", PdfFormField.FF_READ_ONLY, null);
			}
			for (Entry<String, String> e : fieldValue.entrySet()) {
				acroFields.setField(e.getKey(), "Willy Brandt");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		stamper.close();
        reader.close();

    }
	
}
	