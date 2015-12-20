package training.java.gui.application;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import training.java.gui.application.animation.AnimationThread;
import training.java.gui.application.listener.MouseEventListener;
import training.java.gui.application.property.WindowPropertyManager;
import training.java.gui.service.clock.Clock;
import training.java.gui.uiparts.menu.MyMenuBar;
import training.java.gui.utils.MyWindowListener;


public class ApplicationWindow extends Frame {

	//Window info
	private static final long	serialVersionUID	= -8831569702907811356L;
	private static int WIDTH = 800;
	private static int HEIGHT= 400;

	//For use double buffering
	Image bImage;
	Graphics bg;
	
	//GUI info
	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	public static Color bgColor   = Color.WHITE;
	public static Color fontColor = Color.RED;
	public static int   fontSize  = 80; 
	public static Font  font      = new Font(Font.SERIF, Font.BOLD, fontSize);

	/**
	 * Calls initializations and starts animation thread
	 */
	public ApplicationWindow() {
		super();
		init();
		setWindowComponent();
		setGuiInfo();
		//Start Animation
		AnimationThread animation = new AnimationThread(this);
		animation.start();
	}

	/**
	 * initialize window
	 */
	private void init() {
		//Set Window Layout etc...
		setVisible(true);
		setLayout(new FlowLayout());
		final int default_x = 200;
		final int default_y = 200;
		setBounds(default_x, default_y, WIDTH, HEIGHT);
		setSize(WIDTH, HEIGHT);
		//Add Listeners
		addMouseListener(new MouseEventListener(this));
		addWindowListener(new MyWindowListener());
	}

	/**
	 * set parameters related to Componets.
	 */
	private void setWindowComponent() {
		setMenuBar(new MyMenuBar());
	}

	/**
	 * set parameters related to GUI.
	 */
	private void setGuiInfo() {
		setBackground(bgColor);
		wpm.setBgColor(bgColor);
		wpm.setFontColor(fontColor);
		wpm.setFont(font);
		wpm.setFontSize(fontSize);
	}

	//<--- Draw Image --->

	/**
	 * Draw component
	 * This method is called by AnimationThread
	 */
	public void paint(Graphics g) {
		if(bg == null) bg = bImage.getGraphics();
		//1. Clear Previous Buffered Image
		setBgGraphics(bg, wpm.getBgColor());
		//2. Draw
		setBgFont(bg, wpm.getFont(), wpm.getFontColor(), wpm.getFontSize());
		//3. Draw Buffered Image
		g.drawImage(bImage, 0, 0, this);
	}

	/**
	 * For use double buffering
	 */
	public void update(Graphics g) {
		paint(g);
	}

	public void addNotify() {
		super.addNotify();
		bImage = createImage(WIDTH, HEIGHT);		
	}

	/**
	 * set BackgrandGraphics' Background indicated parameter, 1th, Color.
	 * @param bg
	 * @param bgColor
	 */
	private void setBgGraphics(Graphics bg, Color bgColor) {
		bg.setColor(bgColor);
		bg.fillRect(0, 0, WIDTH, HEIGHT);
	}

	/**
	 * set background Graphics font and its color.
	 * @param bg
	 * @param font
	 * @param fontColor
	 */
	private void setBgFont(Graphics bg, Font font, Color fontColor, float size) {
		if(font != null) {
			font = font.deriveFont(size);
		} else {
			font = this.font;
		}
		bg.setFont(font);
		bg.setColor(fontColor);
		
		int drawPosition_x = (this.getSize().width - font.getSize()*4)/2;
		int drawPosition_y = (getSize().height + font.getSize())/2;
		bg.drawString(Clock.getClockInstance().getTimeString(), drawPosition_x , drawPosition_y);
		this.setSize(font.getSize()*6, font.getSize()*2);
	}
}

