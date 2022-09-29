package view;

import javax.swing.ImageIcon;

public class ModelItems {

	private String name;
	private ImageIcon icon;

	public ModelItems(String name, ImageIcon icon) {
		super();
		this.name = name;
		this.icon = icon; 
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}	
}