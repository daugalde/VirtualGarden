package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

 
@SuppressWarnings({ "serial", "rawtypes" })
public class ModelPainter 
extends JLabel
implements ListCellRenderer
{

	
	public ModelPainter() {
		setOpaque(true);
		
	}

	@Override
	public Component getListCellRendererComponent(
			JList list, Object value, int index, 
			boolean isSelected,	boolean cellHasFocus) 
	{

		ModelItems item = (ModelItems) value;
		
		this.setText(item.getName());
		
		this.setIcon(item.getIcon());
	        
		if (isSelected)
		{
			setBackground(Color.DARK_GRAY);
			setForeground(Color.WHITE);
		}
		
		if (!isSelected)
		{
			setBackground(Color.RED);
			setForeground(Color.WHITE);
		}
		
		if (cellHasFocus)
		{
			setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		
		else
		{
			setBorder(BorderFactory.createEmptyBorder());
		}
		return this;
	}

	
		 
}
