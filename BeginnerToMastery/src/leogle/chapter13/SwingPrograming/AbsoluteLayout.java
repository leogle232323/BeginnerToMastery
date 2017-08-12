package leogle.chapter13.SwingPrograming;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AbsoluteLayout extends JFrame {

	private static final long serialVersionUID = 1L;

	public AbsoluteLayout() {
		// 1.设置窗体的标题
		setTitle("本窗体使用绝对布局");
		// 2.使该窗体取消布局管理器设置
		setLayout(null);
		// 3.绝对定位窗体的位置与大小
		setBounds(0, 0, 500, 500);
		// 4.创建容器对象
		Container container = getContentPane();
		// 5.创建按钮
		JButton b1 = new JButton("按钮1");
		JButton b2 = new JButton("按钮2");
		// 6.设置按钮的位置与大小
		b1.setBounds(10, 30, 80, 30);
		b2.setBounds(60, 70, 80, 30);
		// 7.将按钮添加到容器中
		container.add(b1);
		container.add(b2);
		// 8.设置窗体可见
		setVisible(true);
		// 9.设置窗体默认关闭方式
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AbsoluteLayout();
	}

}
