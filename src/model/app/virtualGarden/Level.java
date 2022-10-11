package model.app.virtualGarden;

public class Level extends SimulatorObject{

	private int min;
	
	private int max;
	
	public Level () {
		super(0,"");
	}

	public Level (int id, String name, int min, int max) {
		super(id,name);
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public boolean hasExceededMax() {
		return this.max > 100;
	}
	
	public boolean hasExceededMin() {
		return this.min < 0;
	}
}
