package model.app.virtualGarden;

import java.util.ArrayList;

public class Garden extends SimulatorObject{
	
	private ArrayList<Plant> plants;
	
	public Garden() {
		
	}

	public ArrayList<Plant> getPlants() {
		return plants;
	}

	public void setPlants(ArrayList<Plant> plants) {
		this.plants = plants;
	}
}
