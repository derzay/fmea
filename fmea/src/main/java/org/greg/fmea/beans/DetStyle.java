package org.greg.fmea.beans;

public class DetStyle {
	
	private int id;
	private String name;
	private String description;
	
	public DetStyle() {
	}
	
	public DetStyle(int _id, String _name, String _description) {
		this.id = _id;
		this.name = _name;
		this.description = _description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static void main(String[] args) {

	}

}
