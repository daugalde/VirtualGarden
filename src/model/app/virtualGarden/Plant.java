package model.app.virtualGarden;

public class Plant extends SimulatorObject{
	
	private LifeCycle lifeCycle;
	
	public Plant () {
		super();
	}
	
    public Plant (int id, String name) {
    	super (id, name);
	}

 	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	
	@Override
	public String toString() {
		return "Id " + getId() + " Name " + getName();
	}
}
