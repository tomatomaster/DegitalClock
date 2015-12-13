package training.java.gui.application;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import training.java.gui.application.inf.WindowPropertyManager;


public class ApplicationWindow extends Frame {

	//Window info
	private static final long	serialVersionUID	= -8831569702907811356L;
	private static int WIDTH = 500;
	private static int HEIGHT= 500;
	private static final int default_x = 200;
	private static final int default_y = 200;

	//Clock info
	Clock clock = new Clock();

	//Menu info
	MyPopupMenu popUpMenu;

	//For use double buffering
	Dimension dimension;
	Image bImage;
	Graphics bg;

	//GUI info
	WindowPropertyManager wpm = WindowPropertyManager.getInstance();
	public static Color bgColor   = Color.WHITE;
	public static Color fontColor = Color.RED;
	public static int   fontSize  = 120; 
	public static Font  font      = new Font(Font.SERIF, Font.BOLD, fontSize);

	/**
	 * Calls initializations and starts animation thread
	 * @param fr
	 */
	public ApplicationWindow() {
		super();
		AnimationThread animation = new AnimationThread(this);
		animation.start();
		init();
		setWindowComponent();
		setGuiInfo();
	}

	/**
	 * initialize window
	 */
	private void init() {
		//Set Window Layout etc...
		setVisible(true);
		setLayout(new FlowLayout());
		setBounds(default_x, default_y, 250, 250);
		setSize(WIDTH, HEIGHT);

		//Add Listeners
		addMouseListener(new MouseEventListener(this));
	}

	/**
	 * set parameters related to Componets.
	 */
	private void setWindowComponent() {
		//Add Buttons
		//1. Exit Button
		Button exitButton= new Button("Exit");
		add(exitButton);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		//Add PopUpMenu
		popUpMenu = new MyPopupMenu(); 
		add(popUpMenu);
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
		bg.drawString(clock.getTimeString(), (this.getSize().width - font.getSize()*4)/2 , (getSize().height + font.getSize())/2);
		this.setSize(font.getSize()*5, font.getSize()*2);
	}
}

