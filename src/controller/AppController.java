package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import loaders.IFileLoader;
import loaders.Loader;
import model.app.AppModel;
import model.app.virtualGarden.Simulator;
import view.AppView;

public class AppController {

	private AppModel model;

	private AppView view;
	
	private Thread simulate;
	
	private Simulator simulator;

	public AppController() {
		this.model = new AppModel();
		this.view = new AppView("Virtual Garden");
	}

	public AppController(AppModel model, AppView view) {
		this.setModel(model);
		this.setView(view);
	}

	public AppModel getModel() {
		return model;
	}

	public void setModel(AppModel model) {
		this.model = model;
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
		
		view.InitView(simulator);
				
		addEventListeners();
		
	}
	
	public void addEventListeners() {
		view.getSimulateBtn().addActionListener(e -> startSimulation());
	}
	
	private void startSimulation() {
		resetUI () ;
				
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
	
	private void resetUI () {
		
	}
}