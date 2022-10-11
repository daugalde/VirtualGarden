package common;

import java.util.ArrayList;

public class Observable {
	private ArrayList<IObserver> observers;
	
	public Observable() {
		observers = new ArrayList<IObserver>();
	}
	
	public void addObserver(IObserver pObservable) {
		observers.add(pObservable);
	}
	
	public void removeObserver(IObserver pObservable) {
		observers.remove(pObservable);
	}
	
	public void notifyObservers(Object pValue) {
		for(IObserver observer : observers) {
			observer.update(this, pValue);
		}
	}
	
	public void notify(Object pValue) {
		Observable thisInstance = this;
		
		for(IObserver observer : observers) {
			observer.update(thisInstance, pValue);
		}
	}
}
