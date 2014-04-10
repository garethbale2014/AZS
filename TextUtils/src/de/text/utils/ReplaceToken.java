package de.text.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ReplaceToken {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (FileReader reader = new FileReader("text_bal.properties")) {
      Properties properties = new Properties();
      properties.load(reader);

      Enumeration e = properties.propertyNames();
      int i = 0;

      for (; e.hasMoreElements();) {
        //if (String.valueOf(e.nextElement()).startsWith("Formular1[0].Seite1[0]")) {
          StringBuilder enumValue = new StringBuilder(String.valueOf(e.nextElement()));
          StringBuilder element = new StringBuilder(String.valueOf(enumValue).replace(".", "_"));
          String key = element.toString().toUpperCase().replace("[", "");
          key = key.replace("]", "");
          key = key.replace("#", "");
          String value = new StringBuilder("(" + "\"").append(enumValue).append("\"").append(")").toString();
          if(key.startsWith("FORMULAR10_SEITE10"))
            System.out.println(key + value + ",");
       // }

      }

      // while (e.hasMoreElements()) {
      // String key = (String) e..nextElement();
      // System.out.println(key );
      // //System.out.println(key + " -- " + properties.getProperty(key));
      // }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
