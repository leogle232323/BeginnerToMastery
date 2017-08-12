package leogle.chapter13.SwingPrograming;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class JFrameWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new JFrameWindow("第一个JFrame窗体");
	}

	public JFrameWindow(String title) {
		// 1.实例化一个JFrame对象
		JFrame jf = new JFrame(title);

		// 2.获取一个容器
		Container container = jf.getContentPane();

		// 3.创建一个JLabel标签
		JLabel jl = new JLabel("这是一个JFrame窗体");
		// 4.使标签上的文字居中
		jl.setHorizontalAlignment(JLabel.LEFT);
		// 5.将标签添加到容器中
		container.add(jl);

		// 6.设置容器背景颜色
		container.setBackground(Color.gray);
		// 7.使窗体可见
		jf.setVisible(true);
		// 8.设置窗体大小
		jf.setBounds(100, 100, 300, 300);
		// 9.设置窗体默认关闭方式
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
