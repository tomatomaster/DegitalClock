package training.java.gui.uiparts.menu;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;

final class BackGroundColorMenu extends Menu implements ActionListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -714205455171293377L;

	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	List<MenuItem> menuItems = new ArrayList<>();
	MenuItem redItem    = new MenuItem("red");
	MenuItem blackItem  = new MenuItem("black");
	MenuItem yellowItem = new MenuItem("yellow");
	
	{
		menuItems.add(redItem);
		menuItems.add(blackItem);
		menuItems.add(yellowItem);
	}
	
	public BackGroundColorMenu() {
		super("BackGroundColor");
		for(MenuItem item: menuItems) {
			add(item);
		}
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//0. get parameter, MenuItem("THIS").
		String colorName = e.getActionCommand();
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
	
}
