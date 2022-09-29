package model.app.virtualGarden;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Simulator implements Runnable {
	
	private int simulationTime;
	private ArrayList<Season> seasons;
	private ArrayList<Size> sizes;
	private ArrayList<Level> levels;
	private ArrayList<Plant> garden;
	private LocalDateTime startedTime = LocalDateTime.now();
	private LocalDateTime weatherLastUpdate;
	private int dayPass;
	private boolean running = false;
	
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public LocalDateTime getWeatherLastUpdate() {
		return weatherLastUpdate;
	}
	public void setWeatherLastUpdate(LocalDateTime weatherLastUpdate) {
		this.weatherLastUpdate = weatherLastUpdate;
	}
	
	public LocalDateTime getStartedTime() {
		return startedTime;
	}
	
	public void setStartedTime(LocalDateTime startedTime) {
		this.startedTime = startedTime;
	}
	
	public int getDayPass() {
		return dayPass;
	}
	
	public void setDayPass(int dayPass) {
		this.dayPass = dayPass;
	}
	
	public int getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(int simulationTime) {
		this.simulationTime = simulationTime;
	}
	
	public ArrayList<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(ArrayList<Season> seasons) {
		this.seasons = seasons;
	}

	public ArrayList<Size> getSizes() {
		return sizes;
	}

	public void setSizes(ArrayList<Size> sizes) {
		this.sizes = sizes;
	}

	public ArrayList<Level> getLevel() {
		return levels;
	}

	public void setLevel(ArrayList<Level> level) {
		this.levels = level;
	}
	public ArrayList<Plant> getPlants() {
		return garden;
	}
	public void setPlants(ArrayList<Plant> plants) {
		this.garden = plants;
	}
	
	@Override
	public void run() {
		int periodTimeOption =  simulationTime*60;
		
		for(int i = 0; i < periodTimeOption ; i++) {        	
			try {

				Thread.sleep(1000);
				
				
				System.out.println("Simulacion Iniciada " + i);
				
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
		
	}
}
