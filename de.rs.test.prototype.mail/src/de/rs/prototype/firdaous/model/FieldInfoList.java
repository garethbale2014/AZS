package de.rs.prototype.firdaous.model;

import java.util.ArrayList;
import java.util.List;

public class FieldInfoList extends ArrayList<IPDFFieldInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159996519705639464L;
	
	private List<IPDFFieldInfo> fieldInfoList = new ArrayList<IPDFFieldInfo>();

	public FieldInfoList(List<IPDFFieldInfo> fieldInfoList) {
		if (fieldInfoList != null)
			this.fieldInfoList = fieldInfoList;

	}

	public FieldInfoList() {

	}

	public IField getIField(String key) {
		IField field = null;
		for (IPDFFieldInfo fieldInfo : fieldInfoList) {
			if (fieldInfo.getPdfName().equals(key)) {
				field = new Field(fieldInfo);
				break;

			}
		}
		return field;
	}
	
	public IPDFFieldInfo getPDFFieldInfo(String key){
	  IPDFFieldInfo field = null;
	  for (IPDFFieldInfo fieldInfo : fieldInfoList) {
      if (fieldInfo.getPdfName().equals(key)) {
        field = fieldInfo;
        break;

      }
    }
	  return field;
	}

}
