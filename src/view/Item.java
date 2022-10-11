package view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import model.app.virtualGarden.Plant;

@SuppressWarnings({ "rawtypes", "serial" })
public class Item extends DefaultListModel
{
	public Item() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void AddItem(ArrayList<Plant> plants) {
		for (int index = plants.size() - 1; index >= 0; index--) {

			  ModelItems item = new ModelItems(plants.get(index).toString(), new ImageIcon(plants.get(index).getLifeCycle().getImage()));
	    	
	    	  addElement(item);
	     }		
	}
}