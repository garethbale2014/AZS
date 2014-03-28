package de.rs.prototype.firdaous.model;

import java.util.Date;
import java.util.List;

public class FieldInfo implements IPDFFieldInfo {

	String name;
	String pdfName;
	FieldType fieldType;
	Integer fieldValueInt;
	Long fieldValueLong;
	String fieldValueString;
	Boolean fieldValueBoolean;
	Date fieldValueDate;
	Character fieldValueCharacter;
	List<Object> fieldValueList;
	Object fieldObjectValue;

	public FieldInfo(String name, String pdfName, Object value ) {
		this.name = name;
		this.pdfName = pdfName;
		this.fieldObjectValue = value;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getPdfName() {
		return pdfName;
	}

	@Override
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}


	@Override
	public FieldType getFieldType() {
		return fieldType;
	}

	@Override
	public Object getFieldValue() {
		return fieldObjectValue;
	}

	@Override
	public Integer getFieldValueInt() {
		return fieldValueInt;
	}

	@Override
	public Long getFieldValueLong() {
		return fieldValueLong;
	}

	@Override
	public String getFieldValueString() {
		return fieldValueString;
	}

	@Override
	public Boolean getFieldValueBoolean() {
		return fieldValueBoolean;
	}

	@Override
	public Date getFieldValueDate() {
		return fieldValueDate;
	}

	@Override
	public Character getFieldValueCharacter() {
		return fieldValueCharacter;
	}

	@Override
	public List<Object> getFieldValueList() {
		return fieldValueList;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public void setFieldValueInt(Integer fieldValueInt) {
		this.fieldValueInt = fieldValueInt;
	}
	@Override
	public void setFieldValueLong(Long fieldValueLong) {
		this.fieldValueLong = fieldValueLong;
	}
	@Override
	public void setFieldValueString(String fieldValueString) {
		this.fieldValueString = fieldValueString;
	}
	@Override
	public void setFieldValueBoolean(Boolean fieldValueBoolean) {
		this.fieldValueBoolean = fieldValueBoolean;
	}
	@Override
	public void setFieldValueDate(Date fieldValueDate) {
		this.fieldValueDate = fieldValueDate;
	}
	@Override
	public void setFieldValueCharacter(Character fieldValueCharacter) {
		this.fieldValueCharacter = fieldValueCharacter;
	}
	@Override
	public void setFieldValueList(List<Object> fieldValueList) {
		this.fieldValueList = fieldValueList;
	}
	
	@Override
	public Object getFieldObjectValue() {
		return fieldObjectValue;
	}
	@Override
	public void setFieldObjectValue(Object fieldObjectValue) {
		this.fieldObjectValue = fieldObjectValue;
	}
	


}
