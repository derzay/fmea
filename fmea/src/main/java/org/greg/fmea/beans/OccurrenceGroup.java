package org.greg.fmea.beans;

import java.util.ArrayList;

public class OccurrenceGroup {
	
	private OccStyle occStyle;
	private ArrayList<Occurrence> occList;
	
	public OccurrenceGroup(OccStyle _occStyle, ArrayList<Occurrence> _occList) {
		this.setOccStyle(_occStyle);
		this.setOccList(_occList);
	}

	public OccStyle getOccStyle() {
		return occStyle;
	}

	public void setOccStyle(OccStyle occStyle) {
		this.occStyle = occStyle;
	}

	public ArrayList<Occurrence> getOccList() {
		return occList;
	}

	public void setOccList(ArrayList<Occurrence> occList) {
		this.occList = occList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
