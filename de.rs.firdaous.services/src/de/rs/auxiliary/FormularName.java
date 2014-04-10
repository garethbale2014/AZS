package de.rs.auxiliary;

/**
 * 
 * TODO Write a short description of this class.
 *
 * @since  1.0
 * @author r.sahili
 */
public enum FormularName {

  AZF("resources/AZSUnlocked.pdf", "AZS_%s.pdf" ),
  BAL("resources/BALUnlocked.pdf","BAL_%s.pdf"),
  LVN("", ""),
  SF("", "");

  private String fileName;
  
  private String resultFileName;

  private FormularName(String fileName, String resultFileName) {
    this.fileName = fileName;
    this.resultFileName = resultFileName;
  }

  public static String getValueFromName(String name) {
    if (name == null) 
      throw new IllegalArgumentException("Parameter value " + "cannot be null.");
    for (FormularName f : FormularName.values()) {
      if (name.equals(f.name()))
        return f.fileName;
    }

    return null;
  }
  
  public static String getResultFileName(String name) {
    if (name == null) throw new IllegalArgumentException("Parameter value " + "cannot be null.");
    for (FormularName f : FormularName.values()) {
      if (name.equals(f.fileName))
        return f.resultFileName;
    }

    return null;
  }
  
 

}
