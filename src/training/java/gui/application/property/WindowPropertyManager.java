package training.java.gui.application.property;

import java.awt.Color;
import java.awt.Font;

/**
 * Manage window properties.
 * Background Color
 * Font Color
 * Font Size
 * @author ono
 *
 */
public class WindowPropertyManager {
	private Color bgColor;
	private Color fontColor;
	private Font  font;
	private float fontSize;

	private static WindowPropertyManager wpm = new WindowPropertyManager();

	private WindowPropertyManager() {}

	public static WindowPropertyManager getInstance() {
		return wpm;
	}

	public synchronized Color getBgColor() {
		return bgColor;
	}

	public synchronized void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public synchronized Color getFontColor() {
		return fontColor;
	}

	public synchronized void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public synchronized Font getFont() {
		return font;
	}

	public synchronized void setFont(Font font) {
		this.font = font;
	}

	public synchronized float getFontSize() {
		return fontSize;
	}

	public synchronized void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
