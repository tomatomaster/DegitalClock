package training.java.gui.uiparts.menu.item.choice;

import java.awt.Choice;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import training.java.gui.application.property.WindowPropertyManager;

public class FontColorChoice extends Choice {

	private static final long	serialVersionUID	= -7610687646729596309L;
	WindowPropertyManager		wpm					= WindowPropertyManager
															.getInstance();
	List<String>				menuItems			= new ArrayList<>();

	{
		menuItems.add("red");
		menuItems.add("black");
		menuItems.add("yellow");
	}

	public FontColorChoice() {
		super();
		for (final String item : menuItems) {
			add(item.toString());
		}
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String colorName = e.getItem().toString();
				Color color = Color.black;
				if (colorName.equals("yellow")) {
					color = Color.yellow;
				} else if (colorName.equals("red")) {
					color = Color.red;
				} else if (colorName.equals("black")) {
					color = Color.black;
				}
				wpm.setFontColor(color);
			}
		});
	}
}
