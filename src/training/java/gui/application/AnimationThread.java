package training.java.gui.application;





/**
 * Draw NoBorder Animation.
 * @author ono
 *
 */
public class AnimationThread extends Thread {

	NoBorder window;

	/**
	 * 
	 * @param window
	 */
	AnimationThread(NoBorder window) {
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
