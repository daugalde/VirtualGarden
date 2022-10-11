package model.app.virtualGarden;

import common.IObserver;
import common.Observable;

public class Plant extends SimulatorObject implements IObserver{
	
	private int ageDays;
	
	private LifeCycle lifeCycle;
	
	public Plant () {
		super();
	}
	
    public Plant (int id, String name) {
    	setId(id);
    	setName(name);
	}
    
    public Plant (int id, String name, Size s, Level water, Level sun, Level temperature, Level fertilizer) {
    	setId(id);
    	setName(name);
    	this.lifeCycle = new LifeCycle(s, water, sun, temperature, fertilizer);
	}

 	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	
	@Override
	public String toString() {
		return "<HTML>" + "Id : " + getId() + 
			   "<br/> Name : " + getName() +
			   "<br/> Size : " + lifeCycle.getSize().getName() + 
			   "<br/> Water needed : " + lifeCycle.getWaterNeed() .getName() +
			   "<br/> Sun Needed  : "  + lifeCycle.getSunNeed().getName() + 
			   "<br/> Fertilizer Needed  : " + lifeCycle.getFertilizer().getName() +
			   "<br/> Temperature Level to be Healthy  : " + lifeCycle.getTemperature().getName() +
			   "</HTML>";
	}

	@Override
	public void update(Observable pObservable, Object obj) {
		// Here we need to update the LifeCycle
		
		//this.lifeCycle.checkHealth(getAgeDays());
		System.out.println("observable");
		
	}

	public int getAgeDays() {
		return ageDays;
	}

	public void setAgeDays(int ageDays) {
		this.ageDays = ageDays;
	}
}
