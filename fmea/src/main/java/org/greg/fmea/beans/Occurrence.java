package org.greg.fmea.beans;

public class Occurrence {
	
	private int id;
	private int value;
	private String description;
	private int styleId;
	
	public Occurrence(int _id, int _value, String _description, int _styleId) {
		setId(_id);
		setValue(_value);
		setDescription(_description);
		setStyle(_styleId);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStyleId() {
		return styleId;
	}
	public void setStyle(int _styleId) {
		this.styleId = _styleId;
	}
	
	

}
