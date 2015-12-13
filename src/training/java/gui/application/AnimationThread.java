package training.java.gui.application;





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
	AnimationThread(ApplicationWindow window) {
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
