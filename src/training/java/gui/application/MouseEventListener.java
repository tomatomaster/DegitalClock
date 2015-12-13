package training.java.gui.application;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEventListener extends MouseAdapter {
	NoBorder window;
	private final Point startPt = new Point();

	public MouseEventListener(NoBorder window) {
		this.window = window;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//If Windosw run this app, isPopupTrigger is true
		int x = e.getX();
		int y = e.getY();
		if(e.isPopupTrigger()) {
			window.popUpMenu.show(window, x, y);
		}
		Point eventLocationOnScreen = e.getLocationOnScreen();
		window.setLocation(eventLocationOnScreen.x - startPt.x,
				eventLocationOnScreen.y - startPt.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//If iOS run this app, isPopupTrigger is true
		int x = e.getX();
		int y = e.getY();
		if(e.isPopupTrigger()) {
			window.popUpMenu.show(window, x, y);
		}
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
		if(e.isPopupTrigger()) {
			window.popUpMenu.show(window, x, y);
		}
	}
}
