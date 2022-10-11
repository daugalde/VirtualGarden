package model.app.virtualGarden;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import common.Constants;
import view.AppView;

public class Simulator implements Runnable {
	
	private transient AppView appview;
	private int simulationTime;
	private ArrayList<Season> seasons;
	private ArrayList<Size> sizes;
	private ArrayList<Level> levels;
	private Garden garden;

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
	
	public Garden getGarden() {
		return garden;
	}
	
	public void setGarden(Garden garden) {
		this.garden = garden;
	}
	
	public AppView getAppview() {
		return appview;
	}
	
	public void setAppview(AppView appview) {
		this.appview = appview;
		this.appview.InitView();
		this.appview.initJList (garden.getPlants());
		this.appview.getSimulationPeriod().setText( 0 + "    Segundos");
		this.appview.getNumberOfSeasonsForSimulationLabelValue().setText( "" + seasons.size());
	}
	
    private int getTotalDaysOfCurrentYear () {
		
		int currentYear = LocalDate.now().getYear();
		LocalDate dateBefore = LocalDate.parse(currentYear+"-01-01");
	    LocalDate dateAfter = LocalDate.parse(currentYear+"-12-31");
	    long daysDiff = dateBefore.until(dateAfter, ChronoUnit.DAYS);
	    
	    return (int)daysDiff + 1 ;
	}
	
	private Season changeCurrentSeason (Season s, int day) {
		
		LocalDate localDate = LocalDate.now().withDayOfYear( day );
		
		if((seasons.size() == 2 && (day == 1 || day == 184) ) ||
		   (seasons.size() == 4 && (day == 1 || day == 94 || day == 184  || day == 272)  )){
			
			for(int i = 0 ; i < seasons.size(); i++) {
				s = seasons.get(i);
				
				if(localDate.getMonthValue() >= s.getStartMonth() && localDate.getMonthValue() <= s.getEndMonth()) {
					return s;
				}
			}
			
		}
		
		return s;
	}
	
    private Season simulateWeatherConditions (Season s, int day) {
		
    	Season ns =  changeCurrentSeason (s, day) ;
    	   	
    	
    		int temperatureLevel = 0;
    		int sunLevel = 0;
    		int waterLevel = 0;
        	
    		switch(s.getId()) {
    			case Constants.SUNNY:
    			
    				ns.setSun((int) (61 + Math.random() * 100));
    				ns.setTemperature((int) (61 + Math.random() * 100));
    				ns.setWater((int) (0 + Math.random() * 31));

    		    	System.out.println("what is in here SUNNY" + s.toString());
    				break;
    			case Constants.RAINING:
    				temperatureLevel = (int) (61 + Math.random() * 100);
    				sunLevel = (int) (61 + Math.random() * 100);
    				waterLevel = (int) (0 + Math.random() * 31);
    				ns.setSun(sunLevel);
    				ns.setTemperature(temperatureLevel);
    				ns.setWater(waterLevel);
    				
    				System.out.println("what is in here RAINING" + s.toString());
    				break;				
    			case Constants.AUTUM:
    				temperatureLevel = (int) (31 + Math.random() * 60);
    				sunLevel = (int) (31 + Math.random() * 60);
    				waterLevel = (int) (0 + Math.random() * 31);
    				ns.setSun(sunLevel);
    				ns.setTemperature(temperatureLevel);
    				ns.setWater(waterLevel);
    				break;
    			case Constants.WINTER:
    				temperatureLevel = (int) (- 40 + Math.random() * 31);
    				waterLevel = (int) (61 + Math.random() * 100);
    				sunLevel= (int) (0 + Math.random() * 9);
    				ns.setSun(sunLevel);
    				ns.setTemperature(temperatureLevel);
    				ns.setWater(waterLevel);
    				break;
    			default:
    				System.out.println("No se puede indeficicar la Estacion actual");
    		}
   	
    	
		return ns;
	}
	
    private void checkAndAddNewPlantToGarden() {
    	boolean allSizesGreaterThanSeedling = true;
    	
    	for(int i = 0 ; i < garden.getPlants().size(); i++) {
			Plant p = garden.getPlants().get(i);
			if(p.getLifeCycle().getSize().getId() < 1) {
				allSizesGreaterThanSeedling = false;
				break;
			}
		}
    	
    	if(allSizesGreaterThanSeedling) {
			garden.addPlantToGarden(sizes.get(0), levels.get(1), levels.get(2), levels.get(2), levels.get(1));
			this.getAppview().addItemToJList(garden.getPlants());
    	}
    
    }
	
    public void updateStatistics (WeatherConditions currentWeather ) {
    	appview.getWaterLabelValue().setText("" + currentWeather.getCurrentWater());
    	appview.getSunLevel().setText("" + currentWeather.getCurrentSun());
    }
    
	@Override
	public void run() {
		int periodTimeOption =  simulationTime * 60;
		
		int counOfDaysOfYear = getTotalDaysOfCurrentYear ();
		
		int dayPeriod = (int)((counOfDaysOfYear/(periodTimeOption)));
		
		int allDays = 1;
		
		Season newSeason = new Season();
		
		for(int i = 0; i < periodTimeOption ; i++) {
			this.appview.getSimulationPeriod().setText( (i + 1) + "    Segundos");
			try {

				int batchOfDays = allDays + dayPeriod;
				
				if(i == periodTimeOption - 1 && batchOfDays < counOfDaysOfYear) {
					batchOfDays = counOfDaysOfYear ;
				}
				
				for (int day = allDays; day <= batchOfDays; day++) {

					appview.getDaysPassLabelValue().setText(" " + day);
					//Every new day has new weather conditions
					newSeason = simulateWeatherConditions (newSeason, day);
					
					WeatherConditions currentWeather = new WeatherConditions(newSeason, garden.getPlants());
					
					currentWeather.notifyObservers(currentWeather);
					
					updateStatistics (currentWeather );
					
					checkAndAddNewPlantToGarden();				
				}		
				
				allDays = allDays + dayPeriod;
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
		
	}
}
