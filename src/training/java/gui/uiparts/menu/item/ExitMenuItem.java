package training.java.gui.uiparts.menu.item;

import java.awt.MenuItem;

public class ExitMenuItem extends MenuItem {
	
	private static final String ITEM_NAME = "EXIT";
	
	public ExitMenuItem() {
		super(ITEM_NAME);
	}
	
	public static String getItemName() {
		return ITEM_NAME;
	}
}
