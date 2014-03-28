package de.rs.pdf.test.junit;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

import de.rs.pdf.test.IDocumentServiceTest;
import de.rs.pdf.test.ServiceForDocument;


public class TestDocumentService {

	private static String USER_STR_BESTATTER_AUF = "28de068ad96beee2e69c1cafa51ba56f00000000000000000000000000000000";
	private static String OWNER_STR_BESTATTER_AUF = "e812ba0a29d10479a5b321423e4f8fa0a682a46c7f2308873820a30af34832a5";
	 
	 
	public static final  byte[] USER = USER_STR_BESTATTER_AUF.getBytes();
	    /** Owner password. */
	public static final byte[] OWNER = OWNER_STR_BESTATTER_AUF.getBytes();
	
	private IDocumentServiceTest instance;
	
	@Before
	public void setUp(){
		instance = ServiceForDocument.getInstance();
	}
	
	
	@Test
	public void testDecryptDoc() {
		try {
			instance.encryptPdf(null, null);
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
