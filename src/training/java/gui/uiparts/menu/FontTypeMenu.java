package training.java.gui.uiparts.menu;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;


final class FontTypeMenu extends Menu implements ActionListener{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5471774513219284015L;
	
	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	private static final Font[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
	private List<String> menuItemNames = new ArrayList<>();
	
	public FontTypeMenu() {
		super("Font");
		addActionListener(this);
		for(Font font: fontList) {
			String fontName = font.getFontName();
			add(new MenuItem(fontName));
			
			menuItemNames.add(fontName);
		}
	}
	
	//TODO FIX:This method has any problems.
	@Override
	public void actionPerformed(ActionEvent e) {
		//0. get parameter, MenuItem("THIS").
		String fontName = e.getActionCommand();
		//Font font = Font.decode(fontName);
		Font font = new Font(fontName, Font.PLAIN, 100);
		wpm.setFont(font);
	}
}
