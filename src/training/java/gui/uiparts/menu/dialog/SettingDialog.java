package training.java.gui.uiparts.menu.dialog;

import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import training.java.gui.uiparts.menu.item.choice.BackGroundColorChoice;
import training.java.gui.uiparts.menu.item.choice.FontChoice;
import training.java.gui.uiparts.menu.item.choice.FontColorChoice;
import training.java.gui.uiparts.menu.item.choice.FontSizeChoice;

public class SettingDialog extends Dialog {
	private static int					WIDTH	= 400;
	private static int					HEIGHT	= 200;
	private static String				NAME	= "Setting";
	private static final GridBagLayout	layout	= new GridBagLayout();

	public SettingDialog() {
		super(new Frame(), NAME);
		initDialog();
	}

	private void initDialog() {
		setLayout(layout);
		final int default_x = 400;
		final int default_y = 300;
		setBounds(default_x, default_y, WIDTH, HEIGHT);
		addComponents();

		// Close Dialog when press x button
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	/**
	 * components is in dialog discribed in this section
	 */
	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		//1.Labelの設置
		Label fontLabel = new Label("Font");
		Label fontSizeLabel = new Label("Size");
		Label fontColorLabel = new Label("Color");
		Label bgColorLabel = new Label("BGColor");
		//グリッド内のコンポーネント配置位置（右寄せ）
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.setConstraints(fontLabel, gbc);
		gbc.gridy = 1;
		layout.setConstraints(fontSizeLabel, gbc);
		gbc.gridy = 2;
		layout.setConstraints(fontColorLabel, gbc);
		gbc.gridy = 3;
		layout.setConstraints(bgColorLabel, gbc);
		//各種コンポーネントの設定
		add(fontLabel);
		add(fontSizeLabel);
		add(fontColorLabel);
		add(bgColorLabel);
		
		//2.Choiceの設置
		Choice fontChoice = new FontChoice();
		Choice fontSizeChoice = new FontSizeChoice();
		Choice fontColorChoice = new FontColorChoice();
		Choice backGroundColorChoice = new BackGroundColorChoice();
		//グリッド内のコンポーネント配置位置（左寄せ）
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		layout.setConstraints(fontChoice, gbc);
		gbc.gridy = 1;
		layout.setConstraints(fontSizeChoice, gbc);
		gbc.gridy = 2;
		layout.setConstraints(fontColorChoice, gbc);
		gbc.gridy = 3;
		layout.setConstraints(backGroundColorChoice, gbc);

		add(fontChoice);
		add(fontSizeChoice);
		add(fontColorChoice);
		add(backGroundColorChoice);
	}
}
