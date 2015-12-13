package training.java.gui.uiparts.menu;
import java.awt.Menu;
import java.awt.PopupMenu;

/**
 * Manage PopupMenu
 * @author ono
 *
 */
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
