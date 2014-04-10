package de.rs.utils;

import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

public class DateUtils {
  
  
  public static Date createBrithDayRandomly(){
  return new Date(Math.abs(System.currentTimeMillis() - RandomUtils.nextLong()));
  }

}
