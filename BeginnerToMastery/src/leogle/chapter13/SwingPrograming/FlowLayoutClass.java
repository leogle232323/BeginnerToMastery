package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FlowLayoutClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public FlowLayoutClass() {
		setTitle("本窗体使用流布局管理器");
		Container container = getContentPane();
		// 1.设置窗体使用流布局管理器，使组件右对齐（默认居中对齐），并且设置组件之间的水平间隔和垂直间隔
		setLayout(new FlowLayout(2, 10, 10));
		// 2.在容器中循环添加10个按钮
		for (int i = 0; i < 10; i++) {
			container.add(new JButton("button" + i));
		}
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FlowLayoutClass();
	}

}
