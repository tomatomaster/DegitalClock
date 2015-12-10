import java.awt.Menu;
import java.awt.PopupMenu;

import training.java.gui.uiparts.menu.BackGroundColorMenu;
import training.java.gui.uiparts.menu.FontColorMenu;
import training.java.gui.uiparts.menu.FontSizeMenu;
import training.java.gui.uiparts.menu.FontTypeMenu;


public class MyPopupMenu extends PopupMenu {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 8851083428462699463L;
	Menu fontColor  = new FontColorMenu();
	Menu fontType	= new FontTypeMenu();
	Menu fontSize	= new FontSizeMenu();
	Menu bgColor		= new BackGroundColorMenu();
	
	public MyPopupMenu() {
		super();
		add(fontColor);
		add(fontType);
		add(fontSize);
		add(bgColor);
	}
}
