package model.app.virtualGarden;

import java.time.LocalDateTime;

//Sunny Season, Raining Season

public class Season extends SimulatorObject{
	
	
	private int sun;
	private int water;
	private int wind;
	private int temperature;
	private int startMonth;
	private int endMonth;
	private LocalDateTime date = LocalDateTime.now();
	
	public Season() {
		super(0,"");
	}
	
	public Season(int id, String name, int sun, int water, int wind, int temperature, int startMonth, int endMonth) {
		super(id,name);
		this.sun = sun;
		this.water = water;
		this.wind = wind;
		this.temperature = temperature;
		this.startMonth = startMonth <= 0 ? 1 : startMonth;
		this.endMonth = endMonth <= 0 ? 1 : endMonth;
	}
	
	public int getSun() {
		return sun;
	}
	public void setSun(int sun) {
		this.sun = sun;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getWind() {
		return wind;
	}
	public void setWind(int wind) {
		this.wind = wind;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
/*	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	*/

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}