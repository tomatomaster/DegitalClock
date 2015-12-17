package training.java.gui.uiparts.menu;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;


final class FontColorMenu extends Menu implements ActionListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -7610687646729596309L;
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

	public FontColorMenu() {
		super("FontColor");
		for(MenuItem item: menuItems) {
			add(item);
		}
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//0. get parameter, MenuItem("THIS").
		String fontColor = e.getActionCommand();
		Color color = Color.white;
		if(fontColor.equals("yellow")) {
			color = Color.yellow;
		} else if(fontColor.equals("red")) {
			color = Color.red;
		} else if(fontColor.equals("black")) {
			color = Color.black;
		}
		wpm.setFontColor(color);
	}
}
