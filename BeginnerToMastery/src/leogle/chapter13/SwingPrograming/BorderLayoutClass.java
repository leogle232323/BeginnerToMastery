package leogle.chapter13.SwingPrograming;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutClass extends JFrame {

	private static final long serialVersionUID = 1L;
	// 1.定义组件摆放位置的数组
	String[] border = { BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.WEST,
			BorderLayout.EAST };
	String[] buttonName = { "center button", "north button", "south button", "west button", "east button" };

	public BorderLayoutClass() {
		setTitle("本窗体使用边界布局管理器");
		Container container = getContentPane();
		// 2.设置窗体使用边界布局管理器
		setLayout(new BorderLayout());
		for (int i = 0; i < border.length; i++) {
			// 3.在容器中添加按钮，并设置按钮布局
			container.add(new JButton(buttonName[i]), border[i]);
		}

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderLayoutClass();
	}

}
