package training.java.gui.uiparts.menu.item.choice;

import java.awt.Choice;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;

/**
 * 
 * @author ono
 *
 */
public class FontSizeChoice extends Choice {

	private static final long	serialVersionUID	= -5047688637248618970L;

	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	List<Integer> fontSize = new ArrayList<>();

	{
		fontSize.add(30);
		fontSize.add(50);
		fontSize.add(80);
	}

	public FontSizeChoice() {
		super();
		for(final Integer size: fontSize) {
			add(size.toString());
		}
		addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String fontSizeStr = e.getItem().toString();
				int fontSize = Integer.valueOf(fontSizeStr);
				wpm.setFontSize(fontSize);
			}
		});
	}
}
