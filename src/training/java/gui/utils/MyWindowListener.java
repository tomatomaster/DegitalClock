package training.java.gui.utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Window(Frame)に関するアクションを定義するクラス
 * @author ono ryutarou
 *
 */
public class MyWindowListener extends WindowAdapter {
	/**
	 * 閉じるボタンを押した時の挙動
	 * 設定：システムを終了する
	 */
	public void windowClosing (WindowEvent e){
		System.exit(0);
	}

}
