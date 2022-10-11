package controller;

import loaders.IFileLoader;
import loaders.Loader;
import model.app.virtualGarden.Simulator;
import view.AppView;

public class AppController {

	private AppView view;
	
	private Thread simulate;
	
	private Simulator simulator;

	public AppController() {
		this.view = new AppView("Virtual Garden");
	}

	public AppController(AppView view) {
		this.setView(view);
	}

	public AppView getView() {
		return view;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	public void initController() {
		
		IFileLoader loader = new Loader();
		
		simulator = (Simulator)loader.LoadFile(new Simulator());
		
		simulator.setAppview(view);
		
		addEventListeners();
		
	}
	
	public void addEventListeners() {
		simulator.getAppview().getSimulateBtn().addActionListener(e -> startSimulation());
	}
	
	private void startSimulation() {
				
		if(simulate != null && simulate.isAlive()) {
			simulate.interrupt();
			simulate = new Thread(simulator);
			simulate.start();
		}
		else {
			simulate = new Thread(simulator);
			simulate.start();
		}
		
	}
}