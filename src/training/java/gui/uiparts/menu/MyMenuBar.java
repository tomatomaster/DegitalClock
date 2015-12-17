package training.java.gui.uiparts.menu;

import java.awt.Menu;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.List;

public class MyMenuBar extends MenuBar {
	List<Menu> menuList = new ArrayList<Menu>();

	{
		menuList.add(new MyMenu());
	}

	public MyMenuBar() {
		super();
		for(final Menu menu: menuList) {
			add(menu);
		}
	}
}
