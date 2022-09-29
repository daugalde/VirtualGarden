package model.app.virtualGarden;

public class LifeCycle {
	
	private Size size;
	private int health;
	private int waterNeed;
	private int sunNeed;
	private int fertilizer;
	private String Image;
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getWaterNeed() {
		return waterNeed;
	}
	public void setWaterNeed(int waterNeed) {
		this.waterNeed = waterNeed;
	}
	public int getSunNeed() {
		return sunNeed;
	}
	public void setSunNeed(int sunNeed) {
		this.sunNeed = sunNeed;
	}
	public int getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(int fertilizer) {
		this.fertilizer = fertilizer;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
}
