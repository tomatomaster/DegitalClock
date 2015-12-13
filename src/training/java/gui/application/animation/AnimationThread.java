package training.java.gui.application.animation;

import training.java.gui.application.ApplicationWindow;





/**
 * Animation Thread.
 * @author ono
 *
 */
public class AnimationThread extends Thread {

	ApplicationWindow window;

	/**
	 * 
	 * @param window
	 */
	public AnimationThread(ApplicationWindow window) {
		super();
		this.window = window;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		while(true) {
			try {
				window.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
