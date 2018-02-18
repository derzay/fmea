package org.greg.fmea.beans;

import java.util.ArrayList;

public class SeverityGroup {
	
	private SevStyle sevStyle;
	private ArrayList<Severity> sevList;
	
	public SeverityGroup(SevStyle _sevStyle, ArrayList<Severity>_sevList) {
		this.setSevStyle(_sevStyle);
		this.setSevList(_sevList);
	}

	public SevStyle getSevStyle() {
		return sevStyle;
	}

	public void setSevStyle(SevStyle sevStyle) {
		this.sevStyle = sevStyle;
	}

	public ArrayList<Severity> getSevList() {
		return sevList;
	}

	public void setSevList(ArrayList<Severity> sevList) {
		this.sevList = sevList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
