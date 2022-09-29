package view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import model.app.virtualGarden.Plant;

@SuppressWarnings("rawtypes")
public class Item extends DefaultListModel
{
	@SuppressWarnings("unchecked")
	public void AddItem(ArrayList<Plant> plants) {
		for (int index = 0; index < plants.size(); index++) {
	    	  
			ModelItems item = new ModelItems(plants.get(index).getName(), new ImageIcon(plants.get(index).getLifeCycle().getImage()));
	    	
	    	  addElement(item);
	      }
	}
}