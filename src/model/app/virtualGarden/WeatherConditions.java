package model.app.virtualGarden;

import java.util.ArrayList;

import common.Observable;

public class WeatherConditions extends Observable {
	
	private int currentSun;
	
	private int currentWater;
	
	private int currentTemperature;

	public WeatherConditions() {
		
	}
	
    public WeatherConditions(Season season, ArrayList<Plant> plants) {
    	setCurrentSun(season.getSun());
    	setCurrentWater(season.getWater());
    	setCurrentTemperature(season.getTemperature());		
    	 notifyConditions ( plants);
	}

	public int getCurrentWater() {
		return currentWater;
	}
	
	public void setCurrentWater(int currentRain) {
		this.currentWater = currentRain;
	}
	
	public int getCurrentTemperature() {
		return currentTemperature;
	}
	
	public void setCurrentTemperature(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public int getCurrentSun() {
		return currentSun;
	}

	public void setCurrentSun(int currentSun) {
		this.currentSun = currentSun;
	}
	
	public void notifyConditions (ArrayList<Plant> plants) {
		for(int i = 0 ; i < plants.size(); i++) {
			Plant p = plants.get(i);
			this.addObserver(p);
		}
	}
	
	public String toString() {
		return "current sun " + currentSun + "  current water  " + currentWater;
	}
	
}
