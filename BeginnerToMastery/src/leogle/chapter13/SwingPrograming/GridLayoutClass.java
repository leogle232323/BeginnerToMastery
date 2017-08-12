package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GridLayoutClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public GridLayoutClass() {
		setTitle("本窗体使用网格布局管理器");
		Container container = getContentPane();
		setLayout(new GridLayout(7, 3, 5, 5));
		for (int i = 0; i < 20; i++) {
			container.add(new JButton("button" + (i + 1)));
		}

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GridLayoutClass();
	}

}
