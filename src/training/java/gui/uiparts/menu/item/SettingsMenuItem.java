package training.java.gui.uiparts.menu.item;

import java.awt.Dialog;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import training.java.gui.application.ApplicationWindow;
import training.java.gui.uiparts.menu.dialog.SettingDialog;

public class SettingsMenuItem extends MenuItem {

	private final static String MENU_NAME = "Setting";

	/**
	 * Show Setting Dialog
	 */
	public SettingsMenuItem() {
		super(MENU_NAME);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == MENU_NAME) new SettingDialog().setVisible(true);;				
			}
		});
	}
	
}
