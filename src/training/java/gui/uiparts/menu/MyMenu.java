package training.java.gui.uiparts.menu;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.uiparts.menu.item.ExitMenuItem;
import training.java.gui.uiparts.menu.item.SettingsMenuItem;

class MyMenu extends Menu implements ActionListener {

	private final static String MENU_NAME = "MENU";
	private final static List<MenuItem> menuItems = new ArrayList<>();
	
	{
		menuItems.add(new SettingsMenuItem());
	}
	
	public MyMenu() {
		super(MENU_NAME);
		for(final MenuItem menuItem : menuItems) {
			add(menuItem);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == ExitMenuItem.getItemName()) {
			System.exit(0);
		}
	}
}
