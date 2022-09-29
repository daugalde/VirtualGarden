package model.app.virtualGarden;

public abstract class SimulatorObject {
	private int id;
	
	private String name;
	
	public SimulatorObject() {
		
	}
	
	public SimulatorObject(int id, String name) {
		this.id = id;
		this.name = "";
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
}
