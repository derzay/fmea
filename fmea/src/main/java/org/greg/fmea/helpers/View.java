package org.greg.fmea.helpers;

import org.greg.fmea.utils.*;

public class View {
	
	private String mode;
	private String resource;
	
	public View(String _mode, String _resource) {
		this.setMode(_mode);
		this.setResource(_resource);
	}
	

	public String getResource() {
		return resource;
	}
	public void setResource(String _resource) {
		this.resource = _resource;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String _mode) {
		this.mode = _mode;
	}
	
	public boolean isForwardMode() {
		return((this.mode != null) && (this.mode.equals(C.FORWARD)));
	}
	public boolean isRedirectMode() {
		return((this.mode != null) && (this.mode.equals(C.REDIRECT)));
	}

}
