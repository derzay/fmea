package org.greg.fmea.beans;

public class Application {
	
	//skdjfalskjdfal;ksjdkf
	
	private int id;
	private String name;
	
	public Application() {
	}
	
	public Application(int _id, String _name) {
		this.id = _id;
		this.name = _name;
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


	public static void main(String[] args) {
		new Application();
	}

}
