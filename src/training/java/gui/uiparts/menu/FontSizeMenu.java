package training.java.gui.uiparts.menu;


import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;

final class FontSizeMenu extends Menu implements ActionListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5047688637248618970L;
	
	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	List<Integer> fontSize = new ArrayList<>();
	
	{
		fontSize.add(30);
		fontSize.add(50);
		fontSize.add(80);
	}
	
	public FontSizeMenu() {
		super("fontSize");
		addActionListener(this);
		for(Integer size: fontSize) {
			add(new MenuItem(size.toString()));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String fontSizeStr = e.getActionCommand();
		int fontSize = Integer.valueOf(fontSizeStr);
		wpm.setFontSize(fontSize);
	}
}
