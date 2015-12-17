package training.java.gui.uiparts.menu.dialog;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import training.java.gui.uiparts.menu.item.choice.BackGroundColorChoice;
import training.java.gui.uiparts.menu.item.choice.FontSizeChoice;

public class SettingDialog extends Dialog {
	private static int WIDTH = 300;
	private static int HEIGHT = 300;
	private static String NAME = "Setting";
	
	public SettingDialog() {
		super(new Frame(), NAME);
		initDialog();
	}

	private void initDialog() {
		setLayout(new FlowLayout());
		setSize(WIDTH, HEIGHT);
		addComponents();
		
		//Close Dialog when press x button
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	/**
	 * Extract add Methods called.
	 */
	private void addComponents() {
		
		add(new Label("Font"));
		
		add(new Label("FontSize"));
		add(new FontSizeChoice());
		
		add(new Label("Color"));
		
		add(new Label("BGColor"));
		add(new BackGroundColorChoice());
	}
}

