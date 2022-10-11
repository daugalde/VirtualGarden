package model.app.virtualGarden;

import java.util.ArrayList;

public class Garden extends SimulatorObject{
	
	private ArrayList<String> plantTypes;
	
	private ArrayList<Plant> plants;
	
	public Garden() {
		
	}

	public ArrayList<String> getPlantTypes() {
		return plantTypes;
	}

	public void setPlantTypes(ArrayList<String> plantTypes) {
		this.plantTypes = plantTypes;
	}
	
	public ArrayList<Plant> getPlants() {
		return plants;
	}

	public void setPlants(ArrayList<Plant> plants) {
		this.plants = plants;
	}
	
	public void addPlantToGarden(Size s, Level water, Level sun, Level temperature, Level fertilizer) {
		
		int  randomPlantType = (int)(Math.random()*plantTypes.size());
		
		Plant plant = new Plant(plants.size() + 1, plantTypes.get(randomPlantType), s, water, sun, temperature, fertilizer);
		
		this.plants.add(plant);
		
	}
}
