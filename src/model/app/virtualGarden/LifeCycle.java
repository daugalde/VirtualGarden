package model.app.virtualGarden;

import common.Constants;

public class LifeCycle {
	
	private Size size;
	private Level health;
	private Level waterNeed;
	private Level sunNeed;
	private Level fertilizer;
	private Level temperature;
	private String image;
	
    public LifeCycle(Size s, Level water, Level sun, Level temperature, Level fertilizer) {
        this.size = s;
        this.waterNeed = water;
        this.sunNeed = sun;
        this.fertilizer = fertilizer ;
        this.temperature = temperature;
        this.image = Constants.SEEDLING_IMG_PATH;
    }
    
	public Level getHealth() {
		return health;
	}
	
	public void setHealth(Level level) {
		this.health = level;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Level getWaterNeed() {
		return waterNeed;
	}
	
	public void setWaterNeed(Level waterNeed) {
		this.waterNeed = waterNeed;
	}
	
	public Level getSunNeed() {
		return sunNeed;
	}
	
	public void setSunNeed(Level sunNeed) {
		this.sunNeed = sunNeed;
	}
	
	public Level getFertilizer() {
		return fertilizer;
	}
	
	public void setFertilizer(Level fertilizer) {
		this.fertilizer = fertilizer;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Level getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Level temperature) {
		this.temperature = temperature;
	}
}
