package training.java.gui.application.listener;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import training.java.gui.application.ApplicationWindow;

/**
 * 
 * @author ono
 *
 */
public class MouseEventListener extends MouseAdapter {
	ApplicationWindow window;
	private final Point startPt = new Point();

	public MouseEventListener(ApplicationWindow window) {
		this.window = window;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//If Windosw run this app, isPopupTrigger is true
		int x = e.getX();
		int y = e.getY();
		Point eventLocationOnScreen = e.getLocationOnScreen();
		window.setLocation(eventLocationOnScreen.x - startPt.x,
				eventLocationOnScreen.y - startPt.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//If iOS run this app, isPopupTrigger is true
		int x = e.getX();
		int y = e.getY();
		startPt.setLocation(e.getPoint());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point eventLocationOnScreen = e.getLocationOnScreen();
		window.setLocation(eventLocationOnScreen.x - startPt.x,
				eventLocationOnScreen.y - startPt.y);
	};

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}
}
