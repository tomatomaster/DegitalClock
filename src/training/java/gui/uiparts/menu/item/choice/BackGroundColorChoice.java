package training.java.gui.uiparts.menu.item.choice;

import java.awt.Choice;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;

public class BackGroundColorChoice extends Choice {
	private static final long	serialVersionUID	= -714205455171293377L;

	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	List<String> menuItems = new ArrayList<>();
	
	{
		menuItems.add("red");
		menuItems.add("black");
		menuItems.add("yellow");
	}
	
	public BackGroundColorChoice() {
		super();
		for(String item: menuItems) {
			add(item.toString());
		}
		addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				//0. get parameter, MenuItem("THIS").
				String colorName = e.getItem().toString();
				Color color = Color.black;
				if(colorName.equals("yellow")) {
					color = Color.yellow;
				} else if(colorName.equals("red")) {
					color = Color.red;
				} else if(colorName.equals("black")) {
					color = Color.black;
				}
				wpm.setBgColor(color);
				
			}
		});
	}
}
