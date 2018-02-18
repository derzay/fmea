package org.greg.fmea.beans;

import java.util.ArrayList;

public class DetectabilityGroup {
	
	private DetStyle detStyle;
	private ArrayList<Detectability> detList;
	
	public DetectabilityGroup(DetStyle _detStyle, ArrayList<Detectability> _detList) {
		this.setDetStyle(_detStyle);
		this.setDetList(_detList);
	}

	public DetStyle getDetStyle() {
		return detStyle;
	}

	public void setDetStyle(DetStyle detStyle) {
		this.detStyle = detStyle;
	}

	public ArrayList<Detectability> getDetList() {
		return detList;
	}

	public void setDetList(ArrayList<Detectability> detList) {
		this.detList = detList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
