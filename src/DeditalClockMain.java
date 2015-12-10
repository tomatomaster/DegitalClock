import java.awt.Color;
import java.awt.Frame;

public class DeditalClockMain {

	static NoBorder	window;

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		window = new NoBorder(frame);
	}
}
